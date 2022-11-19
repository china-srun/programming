package com.springbootsecurity2.springbootsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity2.springbootsecurity2.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {
    
}
