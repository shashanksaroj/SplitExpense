package com.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {}