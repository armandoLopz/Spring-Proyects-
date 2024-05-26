package com.springweb.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.springbootweb.models.dto.ParamDto;
import com.springweb.springbootweb.models.dto.User;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVaribleController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("mix/{name}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String name, @PathVariable Integer id) {
        
        Map<String, Object> json = new HashMap<>();
        
        json.put("name", name.toUpperCase());
        json.put("Id", id);     
        
        return json;
    }
    
    @PostMapping("/createUser")
    public User create(@RequestBody User user) {

        user.setLastName("lopez".toUpperCase());

        return user;
    }
    
    
}
