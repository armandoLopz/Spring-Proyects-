package com.books.books_springboot.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @ManyToMany
    @JoinTable(

        name = "books_authors",
        joinColumns = @JoinColumn(name = "books_id"),
        inverseJoinColumns = @JoinColumn(name = "authors_id")
    )
    private List<author> authors;

    @ManyToMany
    private List<language> languages;

    @ManyToMany
    private List<genre> genres;

    private String downloadCount;

    private boolean copyrigth;

    @Column(name = "image_url")
    private String image;

    @Embedded
    private date dateTime = new date();

    public book() {
    }

    public book(Long id, String name, List<author> authors, List<language> languages, List<genre> genres,
            String downloadCount, boolean copyrigth, String image, date dateTime) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.languages = languages;
        this.genres = genres;
        this.downloadCount = downloadCount;
        this.copyrigth = copyrigth;
        this.image = image;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getdownloadCount() {
        return downloadCount;
    }

    public void setdownloadCount(String downloadCount) {
        this.downloadCount = downloadCount;
    }

    public boolean isCopyrigth() {
        return copyrigth;
    }

    public void setCopyrigth(boolean copyrigth) {
        this.copyrigth = copyrigth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public date getDateTime() {
        return dateTime;
    }

    public void setDateTime(date dateTime) {
        this.dateTime = dateTime;
    }

    
}
