package com.books.books_springboot.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @NotNull
    private Set<Book>books;

    @NotBlank
    @Size(min = 1, max = 50)
    private String literaryGenre;

    @NotNull
    private List<String> subGenres;

    @Embedded
    private DateTimeVar dateTime = new DateTimeVar();

    public Genre() {
        
        this.books = new HashSet<Book>();
        this.subGenres = new ArrayList<String>();
    
    }

    public Genre(Long id, String literaryGenre, DateTimeVar dateTime) {
        
        this.id = id;
        this.literaryGenre = literaryGenre;
        this.dateTime = dateTime;
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

    public DateTimeVar getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTimeVar dateTime) {
        this.dateTime = dateTime;
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
