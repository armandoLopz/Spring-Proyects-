package com.books.books_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.books_springboot.entities.genre;

public interface genresRepositories extends CrudRepository<genre, Long> {

}
