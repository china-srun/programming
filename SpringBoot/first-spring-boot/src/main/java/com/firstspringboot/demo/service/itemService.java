package com.firstspringboot.demo.service;

import org.springframework.stereotype.Service;

import com.firstspringboot.demo.model.item;

import java.util.*;
@Service
public class itemService {
    public List<item> getItems() {
        List<item> listItems = new ArrayList<>();
        listItems.add(new item("001", "Coca", "pic", 10.0f));
        listItems.add(new item("002", "Pepsi", "pic2", 11.0f));
        return listItems;
    }
}
