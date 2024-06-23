package com.armando.jpa.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name, lastname;
    
    @Column(name = "programming_Lenguaje")
    private String programmingLenguaje;
    

    public Person() {
    }

    public Person(Long id, String name, String lastname, String programmingLenguaje) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLenguaje = programmingLenguaje;
    }

    
    

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", programmingLenguaje="
                + programmingLenguaje + "]";
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

    public String getProgrammingLenguaje() {
        return programmingLenguaje;
    }

    public void setProgrammingLenguaje(String programmingLenguaje) {
        this.programmingLenguaje = programmingLenguaje;
    } 
    
}