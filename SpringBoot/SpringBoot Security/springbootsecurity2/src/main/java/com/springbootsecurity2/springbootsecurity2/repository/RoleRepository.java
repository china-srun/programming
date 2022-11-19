package com.springbootsecurity2.springbootsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity2.springbootsecurity2.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
    
}
