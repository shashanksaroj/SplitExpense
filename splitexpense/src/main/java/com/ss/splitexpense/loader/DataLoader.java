package com.ss.splitexpense.loader;

// DataLoader.java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ss.splitexpense.entities.Expense;
import com.ss.splitexpense.entities.GroupEntity;
import com.ss.splitexpense.entities.User;
import com.ss.splitexpense.repository.ExpenseRepository;
import com.ss.splitexpense.repository.GroupRepository;
import com.ss.splitexpense.repository.UserRepository;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepo;
    private final GroupRepository groupRepo;
    private final ExpenseRepository expenseRepo;

    public DataLoader(UserRepository userRepo, GroupRepository groupRepo, ExpenseRepository expenseRepo) {
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.expenseRepo = expenseRepo;
    }

    @Override
    public void run(String... args) {
        User alice = userRepo.save(new User(null, "Alice"));
        User bob = userRepo.save(new User(null, "Bob"));
        User charlie = userRepo.save(new User(null, "Charlie"));

        GroupEntity g = groupRepo.save(new GroupEntity(null, "Trip", Arrays.asList(alice, bob, charlie)));

        expenseRepo.save(new Expense(null, "Hotel", 300.0, alice, Arrays.asList(alice, bob, charlie), g));
        expenseRepo.save(new Expense(null, "Lunch", 90.0, bob, Arrays.asList(alice, bob), g));
    }
}
