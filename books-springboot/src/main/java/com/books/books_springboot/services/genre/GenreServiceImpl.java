package com.books.books_springboot.services.genre;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Book;
import com.books.books_springboot.services.book.BookService;

public class GenreServiceImpl implements BookService{

    @Override
    public ResponseEntity<?> getAllBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBooks'");
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
    }

    @Override
    public ResponseEntity<?> createBook(Book book, BindingResult result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

    @Override
    public ResponseEntity<?> updateBook(Long id, Book book, BindingResult result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }

    @Override
    public ResponseEntity<?> deleteBook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    @Override
    public ResponseEntity<?> addGenreInBook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addGenreInBook'");
    }

    @Override
    public ResponseEntity<?> addAuthorInBook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAuthorInBook'");
    }

}
