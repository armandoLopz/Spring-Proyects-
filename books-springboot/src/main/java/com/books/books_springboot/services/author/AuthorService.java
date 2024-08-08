package com.books.books_springboot.services.author;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Author;

public interface AuthorService {

    ResponseEntity<?> getAllAuthors();

    ResponseEntity<?> getAuthorkById(Long id);
    
    ResponseEntity<?> createAuthor(Author author,  BindingResult result);
    
    ResponseEntity<?> updateAuthor(Long id, Author author, BindingResult result);

    ResponseEntity<?> deleteAuthor(Long id);

    //ResponseEntity<?> addGenreInBook(Long id);
    
    //ResponseEntity<?> addAuthorInBook(Long id);
}

