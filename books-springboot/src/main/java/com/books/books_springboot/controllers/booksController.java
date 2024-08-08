package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.Book;
import com.books.books_springboot.services.book.BookServiceImpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/book")
public class booksController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("")
    public ResponseEntity<?> getAllBooks() {
        
        return bookServiceImpl.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneBook(@PathVariable("id") Long id) {
        
        return bookServiceImpl.getBookById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book, BindingResult result) {
        
        return bookServiceImpl.createBook(book, result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@Valid @PathVariable("id") Long id , @RequestBody Book book, BindingResult result) {
        
        return bookServiceImpl.updateBook(id, book, result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        
        return bookServiceImpl.deleteBook(id);
    }
}
