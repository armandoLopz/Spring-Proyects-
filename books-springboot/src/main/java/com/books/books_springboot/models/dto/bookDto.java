package com.books.books_springboot.models.dto;

import java.util.List;

import com.books.books_springboot.entities.author;
import com.books.books_springboot.entities.genre;
import com.books.books_springboot.entities.language;

public class bookDto {

    private final Long id;
    private final String name, image;
    private final List<author> authors;
    private final List<language> languages;
    private final List<genre> genres;
    private final Long dowloadCount;

    

    public bookDto(Long id, String name, String image, List<author> authors, List<language> languages,
            List<genre> genres, Long dowloadCount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.authors = authors;
        this.languages = languages;
        this.genres = genres;
        this.dowloadCount = dowloadCount;
    }

    
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<author> getAuthors() {
        return authors;
    }

    public List<language> getLanguages() {
        return languages;
    }

    public List<genre> getGenres() {
        return genres;
    }

    public Long getDowloadCount() {
        return dowloadCount;
    }


    public Long getId() {
        return id;
    }

}
