package com.tgisecurity.tgitest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgisecurity.tgitest.model.CustomerModel;
import com.tgisecurity.tgitest.repository.CustomerRepository;
import com.tgisecurity.tgitest.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerModel> getAllCustomer() {
        return customerRepository.findAll();
    }

    
    
}
