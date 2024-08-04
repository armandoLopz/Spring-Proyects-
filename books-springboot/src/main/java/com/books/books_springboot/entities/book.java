package com.books.books_springboot.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "books")
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(

        name = "books_authors",
        joinColumns = @JoinColumn(name = "books_id"),
        inverseJoinColumns = @JoinColumn(name = "authors_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"books_id", "authors_id"})
    )
    private List<author> authors;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<language> languages;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<genre> genres;

    private Long downloadCount;

    private boolean copyrigth;

    @Column(name = "image_url")
    private String image;

    @Embedded
    private date dateTime = new date();

    public book() {

        this.authors = new ArrayList<author>();
        this.languages = new ArrayList<language>();
        this.genres = new ArrayList<genre>();
    }

    public book(String title, Long downloadCount, boolean copyrigth, String image) {

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

    public LocalDateTime getUpdateTime() {
        return dateTime.getUpdateAt() ;
    }

    public LocalDateTime getCreateTime() {
        return dateTime.getCreateAt() ;
    }

    public void setDateTime(date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

}
