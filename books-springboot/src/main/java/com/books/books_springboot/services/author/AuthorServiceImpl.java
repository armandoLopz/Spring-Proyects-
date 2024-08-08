package com.books.books_springboot.services.author;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Override
    public ResponseEntity<?> getAllAuthors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAuthors'");
    }

    @Override
    public ResponseEntity<?> getAuthorkById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorkById'");
    }

    @Override
    public ResponseEntity<?> createAuthor(Author author, BindingResult result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAuthor'");
    }

    @Override
    public ResponseEntity<?> updateAuthor(Long id, Author author, BindingResult result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAuthor'");
    }

    @Override
    public ResponseEntity<?> deleteAuthor(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAuthor'");
    }

}
