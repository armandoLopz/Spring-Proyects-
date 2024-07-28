package com.books.books_springboot.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class book {

    @Id
    private Long id;
    
    private String name;

    @ManyToMany
    private List<author> authors;

    private List<String> languages;

    private List<String> genders;

    @Column(name = "dowloand_count")
    private String dowloandCount;

    private boolean copyrigth;

    private byte[] image;

    @Embedded
    private date dateTime;

    public book() {
    }

    public book(Long id, String name, List<author> authors, List<String> languages, List<String> genders,
            String dowloandCount,boolean copyrigth, byte[] image) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.languages = languages;
        this.genders = genders;
        this.dowloandCount = dowloandCount;
        this.copyrigth = copyrigth;
        this.image = image;
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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getGenders() {
        return genders;
    }

    public void setGenders(List<String> genders) {
        this.genders = genders;
    }

    public String getDowloandCount() {
        return dowloandCount;
    }

    public void setDowloandCount(String dowloandCount) {
        this.dowloandCount = dowloandCount;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public date getDateTime() {
        return dateTime;
    }

    public void setDateTime(date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isCopyrigth() {
        return copyrigth;
    }

    public void setCopyrigth(boolean copyrigth) {
        this.copyrigth = copyrigth;
    }
    
}
