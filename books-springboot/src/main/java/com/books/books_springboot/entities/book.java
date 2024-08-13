package com.books.books_springboot.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(

        name = "books_authors",
        joinColumns = @JoinColumn(name = "books_id"),
        inverseJoinColumns = @JoinColumn(name = "authors_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"books_id", "authors_id"})
    )
    private Set<Author> authors;

    @NotNull
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Genre> genres;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private Set<Language> languages;

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

    @PrePersist
    public void PrePersistLanguages(){

        languages.forEach(language -> language.getBooks().add(this));
        genres.forEach(genre -> genre.getBooks().add(this));
        authors.forEach(author -> author.getBooks().add(this));
    }

    @PreRemove
    public void beforeRemove() {

        authors.forEach(auth -> auth.getBooks().remove(this));
        
        languages.forEach(lang -> lang.getBooks().remove(this));

        genres.forEach(genre -> genre.getBooks().remove(this));
        
    }

    public Book() {

        //this.authors = new HashSet<Author>();
        //this.languages = new ArraySet<Languages>();
        //this.genres = new ArraySet<Genre>();
    }

    public Book(String title, Long downloadCount, boolean copyrigth, String image, 
                Set<Language> languages, Set<Genre> genres, Set<Author> authors) {

        //this();                
        this.title = title;
        this.downloadCount = downloadCount;
        this.copyrigth = copyrigth;
        this.image = image;

        this.languages = languages;
        this.genres = genres;
        this.authors = authors;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
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
