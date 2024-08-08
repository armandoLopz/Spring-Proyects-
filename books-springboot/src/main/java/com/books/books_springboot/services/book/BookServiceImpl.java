package com.books.books_springboot.services.book;

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
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Book;
import com.books.books_springboot.models.dto.BookDto;
import com.books.books_springboot.repositories.BooksRepositories;

@Service
public class BookServiceImpl implements BookService{

    private BooksRepositories booksRepositories;
    private BookfuntionsService bookfuntionsService;

    public BookServiceImpl(BooksRepositories booksRepositories, BookfuntionsService bookfuntionsService){

        this.booksRepositories = booksRepositories;
        this.bookfuntionsService = bookfuntionsService;
    }


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllBooks() { 
        
        try {
            
            List<Book> allBooks = (List<Book>) booksRepositories.findAll();
            
            if (allBooks.isEmpty()) {
        
                return bookfuntionsService.notFoundError();
            
            }else{

                ModelMapper modelMapper = new ModelMapper();
                List<BookDto> bookDtos = new ArrayList<>();

                for (Book book : allBooks) {
                    
                    BookDto bDto = modelMapper.map(book, BookDto.class);
                    bookDtos.add(bDto);
                }

                return ResponseEntity.ok(bookDtos);
            }

        } catch (Exception e) {
            
            return bookfuntionsService.generalError(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getBookById(Long id) {

        try {

            Optional<Book> bookDB = booksRepositories.findById(id);

            if (bookDB.isPresent()) {
                ModelMapper modelMapper = new ModelMapper();
                BookDto bookDto = modelMapper.map(bookDB, BookDto.class);
                
                return ResponseEntity.ok(bookDto);

            } else {

                Map<String, String> responseBody = new HashMap<>();
                responseBody.put("message", "The ID: " + id + " is not present in DB");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody); 
            }

        } catch (Exception e) {
            
            return bookfuntionsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createBook(Book book, BindingResult result) {

        try {
            if (result.hasFieldErrors()) {
                
                return validationMessages(result);
            }
            booksRepositories.save(book);

            ModelMapper modelMapper = new ModelMapper();
            BookDto bookDto = modelMapper.map(book, BookDto.class);

            return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
            
        } catch (Exception e) {
            
            return bookfuntionsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteBook(Long id) {

        try {
            
            Optional<Book> bookDelete = booksRepositories.findById(id);

            bookDelete.ifPresent(b -> {

                booksRepositories.delete(b);
            });

            if (bookDelete.isPresent()) {
                
                ModelMapper modelMapper = new ModelMapper();
                BookDto bookDto = modelMapper.map(bookDelete, BookDto.class);
                
                return ResponseEntity.ok(bookDto);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        } catch (Exception e) {
          
            return bookfuntionsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateBook(Long id, Book bookRequest, BindingResult result) {
        
        try {

            if (result.hasFieldErrors()) {
                
                return validationMessages(result);
            }
        
            bookRequest.setId(id);
            Optional<Book> bOptional = booksRepositories.findById(bookRequest.getId());
            Book bookUpdate = bOptional.orElseThrow();

            if (bOptional.isPresent()) {

                bookUpdate.setAuthors(bookRequest.getAuthors());
                bookUpdate.setCopyrigth(bookRequest.isCopyrigth());
                bookUpdate.setDownloadCount(bookRequest.getDownloadCount());
                bookUpdate.setGenres(bookRequest.getGenres());
                bookUpdate.setImage(bookRequest.getImage());
                bookUpdate.setLanguages(bookRequest.getLanguages());
                bookUpdate.setTitle(bookRequest.getTitle());

                
                ModelMapper modelMapper = new ModelMapper();
                BookDto bDto = modelMapper.map(bookUpdate, BookDto.class);

                return ResponseEntity.status(201).body(bDto);
            
            }else{

                return ResponseEntity.status(404).body(new HashMap<>().
                put("Message", "Book is Not found in DB")); 
            }
            
        } catch (Exception e) {
          
            return bookfuntionsService.generalError(e);
        }
    }

    private ResponseEntity<?> validationMessages(BindingResult result){

        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {

            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
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
