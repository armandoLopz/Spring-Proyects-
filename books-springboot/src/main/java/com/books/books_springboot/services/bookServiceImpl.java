package com.books.books_springboot.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.books_springboot.entities.book;
import com.books.books_springboot.models.dto.bookDto;
import com.books.books_springboot.repositories.BooksRepositories;

@Service
public class bookServiceImpl implements bookService{

    private BooksRepositories booksRepositories;

    public bookServiceImpl(BooksRepositories booksRepositories){

        this.booksRepositories = booksRepositories;
    }

    //METHOD USED FOR RESPONSE IN INTERNAL SERVER ERRORS
    private static ResponseEntity<Object> responseToServerError(Exception e){

        return ResponseEntity.internalServerError().body(new HashMap<>().
        put("Message", "Error: " + e));

    }

    private static ResponseEntity<Object> notFoundError(){

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "The DB don't have registers of books");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllBooks() { 
        
        try {
            
            List<book> allBooks = (List<book>) booksRepositories.findAll();
            
            if (allBooks.isEmpty()) {
        
                return notFoundError();
            
            }else{

                ModelMapper modelMapper = new ModelMapper();
                List<bookDto> bookDtos = new ArrayList<>();

                for (book book : allBooks) {
                    
                    bookDto bDto = modelMapper.map(book, bookDto.class);
                    bookDtos.add(bDto);
                }

                return ResponseEntity.ok(bookDtos);
            }

        } catch (Exception e) {
            
            return responseToServerError(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getBookById(Long id) {

        try {
            
            Optional<book> bookDB = booksRepositories.findById(id);

            if (bookDB.isPresent()) {
                return ResponseEntity.ok(bookDB.get());

            } else {

                Map<String, String> responseBody = new HashMap<>();
                responseBody.put("message", "The DB don't have registers");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody); 
            }

        } catch (Exception e) {
            
            return responseToServerError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createBook(book book) {

        try {
            
            booksRepositories.save(book);

            ModelMapper modelMapper = new ModelMapper();
            bookDto bookDto = modelMapper.map(book, bookDto.class);

            return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
            
        } catch (Exception e) {
            
            System.out.println(e);
            return responseToServerError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteBook(Long id) {

        try {
            
            Optional<book> bookDelete = booksRepositories.findById(id);

            bookDelete.ifPresent(b -> {

                booksRepositories.delete(b);
            });

            if (bookDelete.isPresent()) {
                
                return ResponseEntity.ok(bookDelete);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        } catch (Exception e) {
          
            return responseToServerError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateBook(book book) {
        
        try {
            
            Optional<book> bOptional = booksRepositories.findById(book.getId());

            if (bOptional.isPresent()) {
                
                ModelMapper modelMapper = new ModelMapper();
                bookDto bDto = modelMapper.map(bOptional, bookDto.class);

                return ResponseEntity.status(201).body(bDto);
            
            }else{

                return ResponseEntity.status(404).body(new HashMap<>().
                put("Message", "Book is Not found in DB")); 
            }
            
        } catch (Exception e) {
          
            return responseToServerError(e);
        }
    }

}
