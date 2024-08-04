package com.books.books_springboot.models.dto;

import java.util.List;

import com.books.books_springboot.entities.author;
import com.books.books_springboot.entities.genre;
import com.books.books_springboot.entities.language;

public class bookDto {

    private Long id;
    private String title, image;
    private List<author> authors;
    private List<language> languages;
    private List<genre> genres;
    private Long downloadCount;
    private boolean copyrigth;
    
    
    public bookDto() {
    }

    public bookDto(Long id, String title, String image, List<author> authors, List<language> languages,
            List<genre> genres, Long downloadCount, boolean copyrigth) {
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

    public List<author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<author> authors) {
        this.authors = authors;
    }

    public List<language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<language> languages) {
        this.languages = languages;
    }

    public List<genre> getGenres() {
        return genres;
    }

    public void setGenres(List<genre> genres) {
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
