package com.armando.pruebas.springboot_practices.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.armando.pruebas.springboot_practices.models.User;

@Repository
public class UserRepository {
    
    @Autowired
    @Qualifier("usersList")
    private List<User> usersList;

    public List<User> showUsers(){

        return usersList;
    }

    public User addUser(User user) {
        
        usersList.add(user);

        return user;
    }
    
}
