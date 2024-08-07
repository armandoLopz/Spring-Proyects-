package com.books.books_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.books_springboot.entities.Author;

public interface AuthorsRepositories extends CrudRepository<Author, Long> {

}
