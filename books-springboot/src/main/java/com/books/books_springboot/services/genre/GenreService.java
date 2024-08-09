package com.books.books_springboot.services.genre;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Genre;

public interface GenreService {

    ResponseEntity<?> getAllGenre();

    ResponseEntity<?> getGenreById(Long id);
    
    ResponseEntity<?> createGenre(Genre genre,  BindingResult result);
    
    ResponseEntity<?> updateGenre(Long id, Genre genre, BindingResult result);

    ResponseEntity<?> deleteGenre(Long id);

}
