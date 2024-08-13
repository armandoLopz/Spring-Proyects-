package com.books.books_springboot.models.dto;

import java.util.List;

import com.books.books_springboot.entities.Author;
import com.books.books_springboot.entities.Genre;
import com.books.books_springboot.entities.Languages;

public class BookDto {

    private Long id;
    private String title, image;
    private List<Author> authors;
    private List<Languages> languages;
    private List<Genre> genres;
    private Long downloadCount;
    private boolean copyrigth;
    
    
    public BookDto() {
    }

    public BookDto(Long id, String title, String image, List<Author> authors, List<Languages> languages,
            List<Genre> genres, Long downloadCount, boolean copyrigth) {
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
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
