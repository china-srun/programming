package com.springbootsecurity2.springbootsecurity2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsecurity2.springbootsecurity2.model.CustomerModel;
import com.springbootsecurity2.springbootsecurity2.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CUSTOMER_READ
    @PreAuthorize("hasPermission(this, 'READ')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomerModel>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    // CUSTOMER_CREATE
    @PreAuthorize("hasPermission(this, 'CREATE')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<CustomerModel>> createCustomer() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
