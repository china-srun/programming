package com.secondproject.secondspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secondproject.secondspringboot.model.category;
import com.secondproject.secondspringboot.service.categoryService;

@RestController
@RequestMapping("/category")
public class categoryContoller {
    @Autowired
    private categoryService CategoryService;

    @RequestMapping(value = {"getById"}, method = RequestMethod.GET)
    public ResponseEntity<category> getSingleCategory(@RequestParam String id){
        if (CategoryService.getById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(CategoryService.getById(id), HttpStatus.OK);
    }
}
