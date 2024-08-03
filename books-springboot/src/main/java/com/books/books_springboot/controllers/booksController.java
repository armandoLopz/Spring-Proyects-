package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.models.dto.bookDto;
import com.books.books_springboot.services.bookServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/book")
public class booksController {

    @Autowired
    private bookServiceImpl bookServiceImpl;

    @GetMapping("")
    public ResponseEntity<?> getAllBooks() {
        
        return bookServiceImpl.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneBook(@PathVariable("id") Long id) {
        
        return bookServiceImpl.getBookById(id);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody bookDto book ) {
        
        return bookServiceImpl.createBook(book);
    }
}
