package com.firstspringboot.demo.service;

import org.springframework.stereotype.Service;

import com.firstspringboot.demo.model.user;

import java.util.*;
@Service
public class userService {
    public List<user> getUsers() {
        List<user> usersList = new ArrayList<user>();
        usersList.add(new user("001", "China the best", "Male"));
        usersList.add(new user("002", "China the best 2", "Male"));
        return usersList;
    }
}
