package com.books.books_springboot.services;

import org.springframework.http.ResponseEntity;

import com.books.books_springboot.entities.book;

public interface bookService {

    ResponseEntity<?> getAllBooks();

    ResponseEntity<?> getBookById(Long id);
    
    ResponseEntity<?> createBook(book book);
    
    ResponseEntity<?> updateBook(book book);

    ResponseEntity<?> deleteBook(Long id);
}
