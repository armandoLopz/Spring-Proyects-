package com.books.books_springboot.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<Book>books;

    @NotBlank
    @Size(min = 1, max = 50)
    private String literaryGenre;

    private List<String> subGenres;

    @Embedded
    private DateTimeVar dateTime = new DateTimeVar();

    public Genre() {
    }

    public Genre(Long id, Set<Book> books, String literaryGenre, List<String> subGenres, DateTimeVar dateTime) {
        this.id = id;
        this.books = books;
        this.literaryGenre = literaryGenre;
        this.subGenres = subGenres;
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
