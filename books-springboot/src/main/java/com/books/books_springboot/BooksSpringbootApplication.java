package com.books.books_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class BooksSpringbootApplication {
	
	public static void main(String[] args) {

		SpringApplication.run(BooksSpringbootApplication.class, args);

	}

}
