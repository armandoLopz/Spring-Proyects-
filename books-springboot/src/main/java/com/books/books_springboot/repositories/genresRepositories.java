package com.books.books_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.books_springboot.entities.genre;

public interface genresRepositories extends JpaRepository<genre, Long> {

}
