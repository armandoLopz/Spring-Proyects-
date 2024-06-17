package com.armando.pruebas.springboot_practices.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.armando.pruebas.springboot_practices.models.User;
import com.armando.pruebas.springboot_practices.models.UserDto;
import com.armando.pruebas.springboot_practices.services.UserServices;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/createUser")
    public UserDto createUser(@RequestBody User user) {
        
        return userServices.addUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> showAllUsers() {
        
        return userServices.showAllUsers();
    }

    @GetMapping("/id/{id}")
    public User getUserForId(@PathVariable int id) {

        return userServices.getUserForId(id);
    }
    
}
