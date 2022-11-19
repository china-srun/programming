package com.springbootsecurity2.springbootsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity2.springbootsecurity2.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    UserRole findByUserId(String userId);
}
