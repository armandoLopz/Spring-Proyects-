package com.armando.pruebas.springboot_practices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armando.pruebas.springboot_practices.models.User;
import com.armando.pruebas.springboot_practices.models.UserDto;
import com.armando.pruebas.springboot_practices.repositories.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public UserDto addUser(User user) {

        userRepository.addUser(user);
        UserDto userDto = new UserDto();
        userDto.setName("El usuario: "+ user.getName() + " " + user.getLastname() + " ha sido creado con exito!!!");

        return userDto;
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
