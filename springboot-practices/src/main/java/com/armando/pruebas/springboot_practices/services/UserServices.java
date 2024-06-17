package com.armando.pruebas.springboot_practices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armando.pruebas.springboot_practices.models.User;
import com.armando.pruebas.springboot_practices.repositories.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {

        System.out.println(user.getName());
        return userRepository.addUser(user);
    }

    public List<User> showAllUsers() {
        
        return userRepository.showUsers();
    }

    public User getUserForId(int id){

        return userRepository.showUsers().stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .get();
    }
    
}
