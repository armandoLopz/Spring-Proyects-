package com.armando.jpa.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/book")
public class bookController {
    
 
    @GetMapping("/")
    public String getMethodName() {
        return "Working";
    }
    
}