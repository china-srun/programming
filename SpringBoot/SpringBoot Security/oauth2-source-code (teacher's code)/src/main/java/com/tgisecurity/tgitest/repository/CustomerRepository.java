package com.tgisecurity.tgitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgisecurity.tgitest.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, String> {
    
}
