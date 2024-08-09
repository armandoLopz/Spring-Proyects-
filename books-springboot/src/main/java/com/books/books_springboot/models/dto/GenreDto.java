package com.books.books_springboot.models.dto;

import java.util.List;
import java.util.Set;

import com.books.books_springboot.entities.Book;

public class GenreDto {

    private Long id;

    private Set<Book> books;

    private String literaryGenre;

    private List<String> subGenres;
    
    public GenreDto() {
    }

    
    public GenreDto(Long id, Set<Book> books, String literaryGenre, List<String> subGenres) {
        this.id = id;
        this.books = books;
        this.literaryGenre = literaryGenre;
        this.subGenres = subGenres;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getLiteraryGenre() {
        return literaryGenre;
    }

    public void setLiteraryGenre(String literaryGenre) {
        this.literaryGenre = literaryGenre;
    }

    public List<String> getSubGenres() {
        return subGenres;
    }

    public void setSubGenres(List<String> subGenres) {
        this.subGenres = subGenres;
    }

}
