package com.books.books_springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.books.books_springboot.entities.book;
import com.books.books_springboot.repositories.BooksRepositories;

@Service
public class bookServiceImpl implements bookService{

    private BooksRepositories booksRepositories;

    public bookServiceImpl(BooksRepositories booksRepositories){

        this.booksRepositories = booksRepositories;
    }

    @Override
    public ResponseEntity<List<book>> getAllBooks() {
        
        try {
            
            List<book> allBooks = (List<book>) booksRepositories.findAll();
            
            if (allBooks.isEmpty()) {
                
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(allBooks);

        } catch (Exception e) {
            
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<book> finById(Long id) {

        try {
            
            Optional<book> bookDB = booksRepositories.findById(id);

            if (bookDB.isPresent()) {
                return ResponseEntity.ok(bookDB.get());
            } else {
                return ResponseEntity.notFound().build(); 
            }

        } catch (Exception e) {
            
            return ResponseEntity.internalServerError().build(); 
        }
    }

    @Override
    public ResponseEntity<book> createBook(book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

    @Override
    public ResponseEntity<book> updateBook(book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }





}
