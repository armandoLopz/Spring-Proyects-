package com.books.books_springboot.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String lastname;
    
    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "death_date")
    private Date deathDate;

    @ManyToMany(mappedBy = "authors")
    //@JoinColumn(name = "books_id")
    private List<Book> books;

    @Column(name = "image_url")
    private String image;

    @Embedded
    private DateTimeVar dateTime = new DateTimeVar();

    public Author() {
    }

    public Author(String name,String lastname, Date bornDate, Date deathDate, List<Book> books, String image) {

        this.name = name;
        this.lastname = lastname;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.books = books;
        this.image = image;
    }

    @Override
    public String toString() {
        return "author [id=" + id + ", name=" + name + ", bornDate=" + bornDate + ", deathDate=" + deathDate
                + ", dateTime=" + dateTime + "]";
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

    public DateTimeVar getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTimeVar dateTime) {
        this.dateTime = dateTime;
    }
    
}
