package com.books.books_springboot.services.book;

import java.util.ArrayList;
import java.util.List;
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
import com.books.books_springboot.services.FuntionsErrorsService;

@Service
public class BookServiceImpl implements BookService{

    private BooksRepositories booksRepositories;
    private FuntionsErrorsService funtionsErrorsService;

    public BookServiceImpl(BooksRepositories booksRepositories, FuntionsErrorsService funtionsErrorsService){

        this.booksRepositories = booksRepositories;
        this.funtionsErrorsService = funtionsErrorsService;
    }


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllBooks() { 
        
        try {
            
            List<Book> allBooks = (List<Book>) booksRepositories.findAll();
            
            if (allBooks.isEmpty()) {
        
                return funtionsErrorsService.notFoundErrorAllEntity("Books");
            
            }
            
            ModelMapper modelMapper = new ModelMapper();
            List<BookDto> bookDtos = new ArrayList<>();

            allBooks.forEach(book -> {
                BookDto bDto = modelMapper.map(book, BookDto.class);
                bookDtos.add(bDto);
            });

            return ResponseEntity.ok(bookDtos);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
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

            }
            
            return funtionsErrorsService.notFoundErrorId(id);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createBook(Book book, BindingResult result) {

        try {
            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }
            
            ModelMapper modelMapper = new ModelMapper();
            BookDto bookDto = modelMapper.map(book, BookDto.class);
            
            booksRepositories.save(book);

            return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
            
        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteBook(Long id) {

        try {
            
            Optional<Book> bookDelete = booksRepositories.findById(id);

            if (bookDelete.isPresent()) {
                
                booksRepositories.delete(bookDelete.orElseThrow());

                ModelMapper modelMapper = new ModelMapper();
                BookDto bookDto = modelMapper.map(bookDelete, BookDto.class);
                
                return ResponseEntity.ok(bookDto);
            }

            return funtionsErrorsService.notFoundErrorId(id);
        
        } catch (Exception e) {
          
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateBook(Long id, Book bookRequest, BindingResult result) {
        
        try {

            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
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
            
            }

            return funtionsErrorsService.notFoundErrorId(id);
            
        } catch (Exception e) {
          
            return funtionsErrorsService.generalError(e);
        }
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
