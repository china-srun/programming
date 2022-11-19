package com.tgisecurity.tgitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgisecurity.tgitest.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String>{
    UserRole findByUserId(String userId);    
}
