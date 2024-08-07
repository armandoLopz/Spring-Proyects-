package com.books.books_springboot.services;

import org.springframework.http.ResponseEntity;

import com.books.books_springboot.entities.Book;

public interface BookService {

    ResponseEntity<?> getAllBooks();

    ResponseEntity<?> getBookById(Long id);
    
    ResponseEntity<?> createBook(Book book);
    
    ResponseEntity<?> updateBook(Long id, Book book);

    ResponseEntity<?> deleteBook(Long id);
}
