package com.books.books_springboot.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.books.books_springboot.entities.book;

public interface bookService {

    ResponseEntity<List<book>> getAllBooks();

    ResponseEntity<?> finById(Long id);
    
    ResponseEntity<?> createBook(book book);
    
    ResponseEntity<?> updateBook(book book);
}
