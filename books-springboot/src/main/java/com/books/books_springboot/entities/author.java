package com.books.books_springboot.entities;

import java.util.Date;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class author {

    @Id
    private Long id;

    @Basic
    private String name;
    
    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "death_date")
    private Date deathDate;

    @ManyToMany
    @Nullable
    @Column(name = "books_written")
    private List<book> booksList;

    @Embedded
    private date dateTime;

    public author() {
    }

    public author(Long id, String name, Date bornDate, Date deathDate) {
        this.id = id;
        this.name = name;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
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

    public date getDateTime() {
        return dateTime;
    }

    public void setDateTime(date dateTime) {
        this.dateTime = dateTime;
    }

    
    
}
