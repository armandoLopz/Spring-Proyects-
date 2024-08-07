package com.books.books_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.books_springboot.entities.Book;

public interface BooksRepositories extends CrudRepository<Book,Long> {

}
