package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("api/author")
public class AuthorController {

    @GetMapping("")
    public String getAllAuthors() {
        return new String();
    }

    @GetMapping("/{id}")
    public String getAuthorById(@PathVariable Long id) {
        return new String();
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }

    @PostMapping("path")
    public String deleteAuthor(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }    

}
