package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.Author;
import com.books.books_springboot.services.author.AuthorServiceImpl;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    private AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorServiceImpl authorServiceImpl){

        this.authorServiceImpl = authorServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllAuthors() {
        return authorServiceImpl.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Long id) {
        return authorServiceImpl.getAuthorkById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@Valid @PathVariable("id") Long id, @RequestBody Author author, BindingResult result) {
        
        return authorServiceImpl.updateAuthor(id, author, result);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAuthor(@RequestBody Author author, BindingResult result) {
        
        return authorServiceImpl.createAuthor(author, result);
    }    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        
        return authorServiceImpl.deleteAuthor(id);
    }

}
