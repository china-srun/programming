package com.firstspringboot.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringboot.demo.model.user;
import com.firstspringboot.demo.service.userService;
// this annotation indicates that the class is a controller
@RestController
@RequestMapping("/user")
public class UserController {
    
    // inject service into controller
    @Autowired
    private userService userService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<user>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createUser() {
        return new ResponseEntity<>("Create User", HttpStatus.OK);
    }
}
