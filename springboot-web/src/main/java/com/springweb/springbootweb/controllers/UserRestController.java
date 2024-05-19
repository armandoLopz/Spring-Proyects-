package com.springweb.springbootweb.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/detailsUser2")
    public Map<String,Object> detailsUser(Model model){

        Map<String,Object> bodyResponse = new HashMap<>();
    
        bodyResponse.put("title", "Hola mundo desde Springboot");
        bodyResponse.put("name", "Armando");
        bodyResponse.put("lastname", "Lopez");
        bodyResponse.put("id", "29911900");

        return bodyResponse;
    }

}
