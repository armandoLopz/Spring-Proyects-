package com.books.books_springboot.services.book;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Book;

public interface BookService {

    ResponseEntity<?> getAllBooks();

    ResponseEntity<?> getBookById(Long id);
    
    ResponseEntity<?> createBook(Book book,  BindingResult result);
    
    ResponseEntity<?> updateBook(Long id, Book book, BindingResult result);

    ResponseEntity<?> deleteBook(Long id);

    ResponseEntity<?> addGenreInBook(Long id);
    
    ResponseEntity<?> addAuthorInBook(Long id);
}
