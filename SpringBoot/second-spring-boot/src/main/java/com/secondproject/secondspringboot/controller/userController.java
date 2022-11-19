package com.secondproject.secondspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.secondproject.secondspringboot.dataTransferObject.userDto;
import com.secondproject.secondspringboot.model.user;
import com.secondproject.secondspringboot.service.userService;

import java.util.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService UserService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<user>> getUser() {
        return new ResponseEntity<List<user>>(UserService.getUsers(), HttpStatus.OK);
    } 

    // we want the object we add as a json object
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<user> createUser(@RequestBody userDto addedUser) {
        return new ResponseEntity<>(UserService.createUser(addedUser), HttpStatus.OK);
    }


    // value means another path, in order to access the getById method we have to use getById path in the main path
    @RequestMapping(value = {"getById"}, method = RequestMethod.GET)
    public ResponseEntity<user> getSingleUser(@RequestParam String id) {
        if (UserService.getByUserId(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(UserService.getByUserId(id), HttpStatus.OK);
    }


    @RequestMapping(value = {"update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<user> updateUser(@RequestParam String id,  @RequestBody userDto UserDto) {
        return new ResponseEntity<>(UserService.updateUser(id, UserDto), HttpStatus.OK);
    }

    
    @RequestMapping(value = {"delete"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<user> deleteUser(@RequestParam String id) {
        return new ResponseEntity<>(UserService.deleteUser(id), HttpStatus.OK);
    }
}
