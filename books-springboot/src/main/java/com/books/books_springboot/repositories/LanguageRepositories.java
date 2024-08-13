package com.books.books_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.books_springboot.entities.Language;

public interface LanguageRepositories extends CrudRepository<Language, Long> {

}
