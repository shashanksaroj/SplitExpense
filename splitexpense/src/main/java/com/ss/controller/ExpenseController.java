package com.ss.controller;

// ExpenseController.java
import org.springframework.web.bind.annotation.*;

import com.ss.entities.GroupEntity;
import com.ss.repository.GroupRepository;
import com.ss.service.ExpenseService;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    private final ExpenseService service;
    private final GroupRepository groupRepo;

    public ExpenseController(ExpenseService service, GroupRepository groupRepo) {
        this.service = service;
        this.groupRepo = groupRepo;
    }

    @GetMapping("/balances/{groupId}")
    public Map<String, Double> getBalances(@PathVariable Long groupId) {
        return service.calculateBalances(groupId);
    }

    @GetMapping("/groups")
    public List<GroupEntity> getGroups() {
        return groupRepo.findAll();
    }

    @GetMapping("/settlements/{groupId}")
    public List<String> getSettlements(@PathVariable Long groupId) {
        return service.settleBalances(groupId);
    }

}
