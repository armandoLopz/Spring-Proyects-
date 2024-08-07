package com.books.books_springboot.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<Book>books;

    private String literaryGenre;

    private List<String> subGenres;

    public Genre() {
    }

    public Genre(Long id, String literaryGenre, List<String> subGenres) {
        this.id = id;
        this.literaryGenre = literaryGenre;
        this.subGenres = subGenres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
