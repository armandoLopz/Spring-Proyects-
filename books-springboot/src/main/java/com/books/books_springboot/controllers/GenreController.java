package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.Genre;
import com.books.books_springboot.services.genre.GenreServiceImpl;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private GenreServiceImpl genreServiceImpl;
    public GenreController(GenreServiceImpl genreServiceImpl){

        this.genreServiceImpl = genreServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllGenre() {
        
        return genreServiceImpl.getAllGenre();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable("id") Long id) {
        
        return genreServiceImpl.getGenreById(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> postMethodName(@Valid @RequestBody Genre genre, BindingResult result) {
        
        return genreServiceImpl.createGenre(genre, result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@Valid @PathVariable("id") Long id, @RequestBody Genre genre, BindingResult result) {
        
        return genreServiceImpl.updateGenre(id, genre, result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> requestMethodName(@PathVariable("id") Long id) {
        
        return genreServiceImpl.deleteGenre(id);
    }
}
