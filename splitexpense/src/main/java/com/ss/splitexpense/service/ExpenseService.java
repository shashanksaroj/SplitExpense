package com.ss.splitexpense.service;
// ExpenseService.java
import org.springframework.stereotype.Service;

import com.ss.splitexpense.entities.Expense;
import com.ss.splitexpense.entities.User;
import com.ss.splitexpense.repository.ExpenseRepository;
import com.ss.splitexpense.repository.GroupRepository;

import java.util.*;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepo;
    private final GroupRepository groupRepo;

    public ExpenseService(ExpenseRepository expenseRepo, GroupRepository groupRepo) {
        this.expenseRepo = expenseRepo;
        this.groupRepo = groupRepo;
    }

    // Calculate balances per user
    public Map<String, Double> calculateBalances(Long groupId) {
        List<Expense> expenses = expenseRepo.findByGroupId(groupId);
        Map<String, Double> balances = new HashMap<>();

        for (Expense e : expenses) {
            int participants = e.getParticipants().size();
            double share = e.getAmount() / participants;

            // Add negative for participants
            for (User u : e.getParticipants()) {
                balances.put(u.getName(), balances.getOrDefault(u.getName(), 0.0) - share);
            }

            // Add positive for payer
            balances.put(e.getPaidBy().getName(), balances.getOrDefault(e.getPaidBy().getName(), 0.0) + e.getAmount());
        }

        return balances;
    }
    public List<String> settleBalances(Long groupId) {
    Map<String, Double> balances = calculateBalances(groupId);

    // Separate creditors (positive) and debtors (negative)
    List<Map.Entry<String, Double>> creditors = new ArrayList<>();
    List<Map.Entry<String, Double>> debtors = new ArrayList<>();

    for (var entry : balances.entrySet()) {
        if (entry.getValue() > 0.01) creditors.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
        else if (entry.getValue() < -0.01) debtors.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
    }

    // Sort: creditors descending, debtors ascending
    creditors.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
    debtors.sort((a, b) -> Double.compare(a.getValue(), b.getValue()));

    List<String> transactions = new ArrayList<>();
    int i = 0, j = 0;

    while (i < debtors.size() && j < creditors.size()) {
        double debt = -debtors.get(i).getValue(); // positive amount owed
        double credit = creditors.get(j).getValue();

        double settled = Math.min(debt, credit);

        transactions.add(debtors.get(i).getKey() + " pays " + creditors.get(j).getKey() + ": $" + String.format("%.2f", settled));

        // Update balances
        debtors.get(i).setValue(debt - settled * -1); // negative
        creditors.get(j).setValue(credit - settled);

        if (Math.abs(debtors.get(i).getValue()) < 0.01) i++;
        if (creditors.get(j).getValue() < 0.01) j++;
    }

    return transactions;
}

}
