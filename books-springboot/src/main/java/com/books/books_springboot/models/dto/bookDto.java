package com.books.books_springboot.models.dto;

import java.util.Set;

import com.books.books_springboot.entities.Language;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class BookDto {

    private Long id;
    private String title, image;

    @JsonIgnoreProperties(value = "books")
    private Set<AuthorDto> authors;
    
    @JsonIgnoreProperties(value = "books")
    private Set<Language> languages;

    @JsonIgnoreProperties(value = "books")
    private Set<GenreDto> genres;

    private Long downloadCount;
    private boolean copyrigth;
    
    
    public BookDto() {
    }

    public BookDto(Long id, String title, String image, Set<AuthorDto> authors, Set<Language> languages,
            Set<GenreDto> genres, Long downloadCount, boolean copyrigth) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.authors = authors;
        this.languages = languages;
        this.genres = genres;
        this.downloadCount = downloadCount;
        this.copyrigth = copyrigth;
    }

    @Override
    public String toString() {
        return "bookDto [id=" + id + ", title=" + title + ", image=" + image + ", authors=" + authors + ", languages="
                + languages + ", genres=" + genres + ", downloadCount=" + downloadCount + ", copyrigth=" + copyrigth
                + "]";
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreDto> genres) {
        this.genres = genres;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public boolean isCopyrigth() {
        return copyrigth;
    }

    public void setCopyrigth(boolean copyrigth) {
        this.copyrigth = copyrigth;
    }
}
