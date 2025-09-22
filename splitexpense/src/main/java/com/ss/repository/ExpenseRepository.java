package com.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.entities.Expense;

import java.util.List;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByGroupId(Long groupId);
}