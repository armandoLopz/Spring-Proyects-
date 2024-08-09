package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.Genre;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @GetMapping("")
    public String getAllGenre() {
        return "All books";
    }

    @GetMapping("/{id}")
    public String getGenreById(@PathVariable("id") Long id) {
        return new String();
    }
    
    @PostMapping("/create")
    public String postMethodName(@RequestBody Genre genre) {
        //TODO: process POST request
        
        return "Work";
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable("id") Long id, @RequestBody Genre genre) {
        
        return "";
    }

    @DeleteMapping("/{id}")
    public String requestMethodName(@PathVariable("id") Long id) {
        return "Works";
    }
}
