package com.books.books_springboot.models.dto;

import java.util.Date;
import java.util.List;

import com.books.books_springboot.entities.Book;

public class AuthorDto {

    private Long id;

    private String name, lastname, image;

    private Date bornDate, deathDate;

    private List<Book> books;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String name, String lastname, String image, Date bornDate, Date deathDate,
            List<Book> books) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorDto [id=" + id + ", name=" + name + ", lastname=" + lastname + ", image=" + image + ", bornDate="
                + bornDate + ", deathDate=" + deathDate + "]";
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
