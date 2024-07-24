package com.armando.jpa.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.armando.jpa.demo.entities.Book;

public interface BookRepositorie extends CrudRepository<Book, Long>{
    
}
