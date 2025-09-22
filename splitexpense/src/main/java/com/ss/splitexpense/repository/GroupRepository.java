package com.ss.splitexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.splitexpense.entities.GroupEntity;
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {}