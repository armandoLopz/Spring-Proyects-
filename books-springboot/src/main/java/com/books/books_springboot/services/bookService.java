package com.books.books_springboot.services;

import org.springframework.http.ResponseEntity;

import com.books.books_springboot.models.dto.bookDto;

public interface bookService {

    ResponseEntity<?> getAllBooks();

    ResponseEntity<?> getBookById(Long id);
    
    ResponseEntity<?> createBook(bookDto book);
    
    ResponseEntity<?> updateBook(bookDto book);
}
