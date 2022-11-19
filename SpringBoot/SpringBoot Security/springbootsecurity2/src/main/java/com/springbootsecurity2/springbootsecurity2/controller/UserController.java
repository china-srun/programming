package com.springbootsecurity2.springbootsecurity2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsecurity2.springbootsecurity2.model.User;


@RestController
@RequestMapping("/user")
public class UserController {
    
    // USER_READ
    @PreAuthorize("hasPermission(this, 'READ')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllCustomer() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // USER_CREATE
    @PreAuthorize("hasPermission(this, 'CREATE')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<User>> createCustomer() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
