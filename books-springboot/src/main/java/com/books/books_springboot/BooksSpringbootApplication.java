package com.books.books_springboot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.books.books_springboot.entities.author;
import com.books.books_springboot.entities.book;
import com.books.books_springboot.repositories.AuthorsRepositories;
import com.books.books_springboot.repositories.BooksRepositories;

@SpringBootApplication
public class BooksSpringbootApplication  implements CommandLineRunner{

	@Autowired
	private AuthorsRepositories authorRepositories;

	@Autowired
	private BooksRepositories booksRepositories;

	public static void main(String[] args) {
		SpringApplication.run(BooksSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//createAuthors();

		System.out.println("RUNNING");
	}


	@Transactional
	public void createAuthors(){

		author author = new author("Armando", "Lopez", new Date(), new Date(),null,null);
		
		authorRepositories.save(author);
		System.out.println("Registro creado en la DB");
	}
}
