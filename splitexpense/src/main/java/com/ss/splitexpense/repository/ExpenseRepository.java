package com.ss.splitexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.splitexpense.entities.Expense;

import java.util.List;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByGroupId(Long groupId);
}