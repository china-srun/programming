package com.springbootsecurity2.springbootsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity2.springbootsecurity2.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, String>{
    
}
