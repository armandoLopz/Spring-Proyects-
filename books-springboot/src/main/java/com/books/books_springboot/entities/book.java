package com.books.books_springboot.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 2, max = 35)
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(

        name = "books_authors",
        joinColumns = @JoinColumn(name = "books_id"),
        inverseJoinColumns = @JoinColumn(name = "authors_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"books_id", "authors_id"})
    )
    private List<Author> authors;

    @NotNull
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Genre> genres;

    @ManyToMany
    private List<Languages> languages;

    @NotNull
    @Min(value = 0)
    private Long downloadCount;

    private boolean copyrigth;

    @NotBlank
    @Size(min = 5, max = 100)
    @Column(name = "image_url")
    private String image;

    @Embedded
    private DateTimeVar dateTime = new DateTimeVar();

    public Book() {

        //this.authors = new ArrayList<Author>();
        this.languages = new ArrayList<Languages>();
        this.genres = new ArrayList<Genre>();
    }

    public Book(String title, Long downloadCount, boolean copyrigth, String image) {

        this();                
        this.title = title;
        this.downloadCount = downloadCount;
        this.copyrigth = copyrigth;
        this.image = image;
    }

    
    
    @Override
    public String toString() {
        return "book [id=" + id + ", title=" + title + ", authors=" + authors + ", languages=" + languages + ", genres="
                + genres + ", downloadCount=" + downloadCount + ", copyrigth=" + copyrigth + ", image=" + image
                + ", dateTime=" + dateTime + "]";
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
    
    public DateTimeVar getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTimeVar dateTime) {
        this.dateTime = dateTime;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

}
