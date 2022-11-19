package com.firstspringboot.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringboot.demo.model.item;
import com.firstspringboot.demo.service.itemService;


@RestController
@RequestMapping("/item")
public class ItemController {
    
    // to use the service 
    @Autowired
    private itemService itemService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<item>> getItem() {
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createItem() {
        return new ResponseEntity<>("Create Item", HttpStatus.OK);
    }
}
