package com.armando.jpa.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.armando.jpa.demo.entities.Author;

public interface AuthorRepositorie extends CrudRepository<Author, Long>{
    

}
