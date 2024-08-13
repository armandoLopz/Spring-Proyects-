package com.books.books_springboot.models.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GenreDto {

    private Long id;

    @JsonIgnoreProperties(value = "genres")
    private Set<BookDto> books;

    private String literaryGenre;
    
    public GenreDto() {
    }
    
    public GenreDto(Long id, Set<BookDto> books, String literaryGenre) {
        
        this.id = id;
        this.books = books;
        this.literaryGenre = literaryGenre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }

    public String getLiteraryGenre() {
        return literaryGenre;
    }

    public void setLiteraryGenre(String literaryGenre) {
        this.literaryGenre = literaryGenre;
    }

}
