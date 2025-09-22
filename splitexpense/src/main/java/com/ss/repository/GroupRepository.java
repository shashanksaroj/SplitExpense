package com.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.entities.GroupEntity;
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {}