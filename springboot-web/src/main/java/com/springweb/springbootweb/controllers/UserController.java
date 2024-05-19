package com.springweb.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @GetMapping("/detailsUser")
    public String detailsUser(Model model){

        model.addAttribute("title", "Hola mundo desde Springboot");
        model.addAttribute("name", "Armando");
        model.addAttribute("lastname", "Lopez");


        return "detailsUser";
    }

}
