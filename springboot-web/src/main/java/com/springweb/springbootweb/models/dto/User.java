package com.springweb.springbootweb.models.dto;

public class User {
    
    private String name,lastName,email;

    public User(){

    }

    public User(String name, String lastName){

        this.name = name;
        this.lastName = lastName;
    }

    public User(String name, String lastName,String email){

        this(name, lastName);
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
