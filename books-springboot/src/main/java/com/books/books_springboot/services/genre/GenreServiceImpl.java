package com.books.books_springboot.services.genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Genre;
import com.books.books_springboot.models.dto.GenreDto;
import com.books.books_springboot.repositories.GenresRepositories;
import com.books.books_springboot.services.FuntionsErrorsService;

@Service
public class GenreServiceImpl implements GenreService{

    private GenresRepositories genresRepositories;
    private FuntionsErrorsService funtionsErrorsService;

    public GenreServiceImpl(GenresRepositories genresRepositories, FuntionsErrorsService funtionsErrorsService){

        this.genresRepositories = genresRepositories;
        this.funtionsErrorsService = funtionsErrorsService;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllGenre() {
        
        try {

            List<Genre> allGenres = (List<Genre>) genresRepositories.findAll();

            if (allGenres.isEmpty()) {
                
                return funtionsErrorsService.notFoundErrorAllEntity("Genres");
            }

            List<GenreDto> genresDtosList = new ArrayList<>();

            allGenres.forEach(g -> {

                ModelMapper modelMapper = new ModelMapper();
                GenreDto genreDto = modelMapper.map(g, GenreDto.class);
                
                genresDtosList.add(genreDto);
            });

            return ResponseEntity.ok(genresDtosList);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getGenreById(Long id) {
        
        try {

            Optional<Genre> genreDB = genresRepositories.findById(id);

            if (genreDB.isPresent()) {
                
                ModelMapper modelMapper = new ModelMapper();
                GenreDto genreDto = modelMapper.map(genreDB.orElseThrow(), GenreDto.class);

                return ResponseEntity.ok(genreDto);
            }

            return funtionsErrorsService.notFoundErrorId(id);
            
        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createGenre(Genre genre, BindingResult result) {
        
        try {

            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }
            
            ModelMapper modelMapper = new ModelMapper();
            GenreDto genreDto = modelMapper.map(genre, GenreDto.class);

            genresRepositories.save(genre);
            genreDto.setId(genre.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(genreDto);

        } catch (Exception e) {
        
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateGenre(Long id, Genre genreRequest, BindingResult result) {

        try {
            
            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }

            genreRequest.setId(id);
            Optional<Genre> genreDB = genresRepositories.findById(genreRequest.getId());

            if (genreDB.isPresent()) {

                Genre genreUpdate = genreDB.orElseThrow();

                genreUpdate.setId(genreRequest.getId());
                genreUpdate.setBooks(genreRequest.getBooks());
                genreUpdate.setLiteraryGenre(genreRequest.getLiteraryGenre());

                ModelMapper modelMapper = new ModelMapper();
                GenreDto genreDto = modelMapper.map(genreUpdate, GenreDto.class);

                genresRepositories.save(genreUpdate);

                return ResponseEntity.status(HttpStatus.CREATED).body(genreDto);
            }

            return funtionsErrorsService.notFoundErrorId(id);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteGenre(Long id) {
        
        try {

            Optional<Genre> genreDB = genresRepositories.findById(id);

            if (genreDB.isEmpty()) {
                
                return funtionsErrorsService.notFoundErrorId(id);
            }

            genresRepositories.delete(genreDB.orElseThrow());
            
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

}
