package com.armando.jpa.demo.entities;

import java.util.ArrayList;
import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Author {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToMany
    @Nullable
    private ArrayList<Book> books;

    private String name, lastname;
    private Date bornDate, deathDate;
    private int numberBooks;

    public Author() {
    }    
    
    public Author(Long id, ArrayList<Book> books, String name, String lastname, Date bornDate, Date deathDate,
            int numberBooks) {
        this.id = id;
        this.books = books;
        this.name = name;
        this.lastname = lastname;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.numberBooks = numberBooks;
    }

    //Methods

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", bornDate=" + bornDate + ", deathDate=" + deathDate
        + ", numberBooks=" + numberBooks + "]";
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public Date getBornDate() {
        return bornDate;
    }
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
    public Date getDeathDate() {
        return deathDate;
    }
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }
    public int getNumberBooks() {
        return numberBooks;
    }
    public void setNumberBooks(int numberBooks) {
        this.numberBooks = numberBooks;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

}
