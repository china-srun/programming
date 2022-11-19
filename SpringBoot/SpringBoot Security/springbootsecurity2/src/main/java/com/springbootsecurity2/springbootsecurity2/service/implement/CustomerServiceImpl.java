package com.springbootsecurity2.springbootsecurity2.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsecurity2.springbootsecurity2.model.CustomerModel;
import com.springbootsecurity2.springbootsecurity2.repository.CustomerRepository;
import com.springbootsecurity2.springbootsecurity2.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerModel> getAllCustomer() {
        return customerRepository.findAll();
    }
    
}
