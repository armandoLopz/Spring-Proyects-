package com.books.books_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.books_springboot.entities.Genre;

public interface GenresRepositories extends CrudRepository<Genre, Long> {

}
