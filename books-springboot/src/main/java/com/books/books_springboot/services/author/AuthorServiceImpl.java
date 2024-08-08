package com.books.books_springboot.services.author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Author;
import com.books.books_springboot.models.dto.AuthorDto;
import com.books.books_springboot.repositories.AuthorsRepositories;
import com.books.books_springboot.services.FuntionsErrorsService;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorsRepositories authorsRepositories;
    private FuntionsErrorsService funtionsErrorsService;

    public AuthorServiceImpl(AuthorsRepositories authorsRepositories, FuntionsErrorsService funtionsErrorsService){

        this.authorsRepositories = authorsRepositories;
        this.funtionsErrorsService = funtionsErrorsService;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllAuthors() {
        
        try {
            
            List<Author> allAuthors = (List<Author>) authorsRepositories.findAll();

            if (allAuthors.isEmpty()) {
                
                return funtionsErrorsService.notFoundErrorAllEntity("Authors");
            }

            ModelMapper modelMapper = new ModelMapper();
            List<AuthorDto> authorsDtos = new ArrayList<>();

            allAuthors.forEach(author -> {
                AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
                authorsDtos.add(authorDto);
            });

            return ResponseEntity.ok(authorsDtos);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAuthorkById(Long id) {

        try {
            Optional<Author> authorDb = authorsRepositories.findById(id);

            if (authorDb.isPresent()) {
                
                ModelMapper modelMapper = new ModelMapper();
                AuthorDto authorDto = modelMapper.map(authorDb.orElseThrow(), AuthorDto.class);

                return ResponseEntity.ok(authorDto);
            }

            return funtionsErrorsService.notFoundErrorId(id);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createAuthor(Author author, BindingResult result) {
        
        try {

            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }

            authorsRepositories.save(author);
            ModelMapper modelMapper = new ModelMapper();
            AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(authorDto);
            
        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateAuthor(Long id, Author author, BindingResult result) {
        
        try {

            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }
            
            author.setId(id);
            Optional<Author> authorDb = authorsRepositories.findById(author.getId());
            Author authorUpdate = authorDb.orElseThrow();

            if (authorDb.isPresent()) {
                
                authorUpdate.setBornDate(author.getBornDate());
                authorUpdate.setDeathDate(author.getDeathDate());
                authorUpdate.setName(author.getName());
                authorUpdate.setBooks(author.getBooks());
                authorUpdate.setImage(author.getImage());
                authorUpdate.setLastname(author.getLastname());

                authorsRepositories.save(authorUpdate);
                
                ModelMapper modelMapper = new ModelMapper();
                AuthorDto authorDto = modelMapper.map(authorDb, AuthorDto.class);

                return ResponseEntity.status(HttpStatus.CREATED).body(authorDto);
            }
            
            return funtionsErrorsService.notFoundErrorId(id);

        } catch (Exception e) {
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteAuthor(Long id) {
        
        try {

            Optional<Author> authorDB = authorsRepositories.findById(id);

            if (authorDB.isPresent()) {
                
                authorsRepositories.delete(authorDB.orElseThrow());

                return ResponseEntity.noContent().build();
            }

            return funtionsErrorsService.notFoundErrorId(id);
            
        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

}
