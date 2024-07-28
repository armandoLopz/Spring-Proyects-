package com.books.books_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.books_springboot.entities.book;

public interface BooksRepositories extends CrudRepository<book,Long> {

}
