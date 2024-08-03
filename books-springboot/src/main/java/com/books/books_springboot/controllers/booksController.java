package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.book;
import com.books.books_springboot.services.bookServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/book")
public class booksController {

    @Autowired
    private bookServiceImpl bookServiceImpl;

    @GetMapping("")
    public ResponseEntity<List<book>> getAllBooks() {
        
        return bookServiceImpl.getAllBooks();
    }
    
    
}
