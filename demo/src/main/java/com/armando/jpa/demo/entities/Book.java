package com.armando.jpa.demo.entities;

import java.util.Date;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private ArrayList<Author> authors;

    private String title;
    private ArrayList<String> lenguages;
    private ArrayList<String> subjects;
    private Date publicationDate;
    
    public Book() {
    }

    public Book( ArrayList<Author> authors, String title, ArrayList<String> lenguages,
            ArrayList<String> subjects, Date publicationDate) {
       
        this.authors = authors;
        this.title = title;
        this.lenguages = lenguages;
        this.subjects = subjects;
        this.publicationDate = publicationDate;
    }

	@Override
    public String toString() {
        return "Book [id=" + id + ", authors=" + authors + ", title=" + title + ", lenguages=" + lenguages
                + ", subjects=" + subjects + ", publicationDate=" + publicationDate + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getLenguages() {
        return lenguages;
    }



    public void setLenguages(ArrayList<String> lenguages) {
        this.lenguages = lenguages;
    }


    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

}
