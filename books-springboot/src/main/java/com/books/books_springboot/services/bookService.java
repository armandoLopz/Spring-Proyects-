package com.books.books_springboot.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.books.books_springboot.entities.book;

public interface bookService {

    ResponseEntity<List<book>> getAllBooks();

    ResponseEntity<book> finById(Long id);
    
    ResponseEntity<book> createBook(book book);
    
    ResponseEntity<book> updateBook(book book);
}
