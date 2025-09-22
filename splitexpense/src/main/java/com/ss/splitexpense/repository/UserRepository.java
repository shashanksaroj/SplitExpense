package com.ss.splitexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.splitexpense.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {}