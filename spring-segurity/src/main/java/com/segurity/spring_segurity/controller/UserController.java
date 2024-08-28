package com.segurity.spring_segurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segurity.spring_segurity.entities.UserEntity;
import com.segurity.spring_segurity.services.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping()
    public List<UserEntity> getAllUser() {
        
        return userServiceImpl.getUsers();
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        
        return userServiceImpl.createUser(userEntity);
    }
    
    @GetMapping("/get")
    public String get() {
        return "Hello get";
    }

    @PostMapping("/post")
    public String post() {

        return "Hello post";
    }

    @PutMapping("/put")
    public String put() {
        
        return "Hello put";
    }

    @DeleteMapping("/delete")
    public String delete() {
        
        return "Hello delete";
    }
    
}
