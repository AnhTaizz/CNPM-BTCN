package com.tai.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tai.code.entity.identity.User;
import com.tai.code.service.UserService;

@RestController
public class testAPI {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String newAPI(){
        return "Hello World";
    }

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        userService.save(user);
        return "User added successfully";
    }
}
