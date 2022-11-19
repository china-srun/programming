package com.tgisecurity.tgitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgisecurity.tgitest.model.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
    
}