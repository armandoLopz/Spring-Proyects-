package com.armando.jpa.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.armando.jpa.demo.entities.Author;
import com.armando.jpa.demo.entities.Book;
import com.armando.jpa.demo.entities.Person;
import com.armando.jpa.demo.repositories.AuthorRepositorie;
import com.armando.jpa.demo.repositories.BookRepositorie;
import com.armando.jpa.demo.repositories.PersonRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AuthorRepositorie authorRepositorie;

	@Autowired
	private BookRepositorie bookRepositorie;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		createBook();
	}
	
	@Transactional
	public void createBook(){

		Author author = new Author(null, null,"David", "Perez", new Date(), new Date(), 0);
		Author author2 = new Author(null, null,"Fausto", "Rodriguez", new Date(), new Date(), 0);
		ArrayList<Author> authors = new ArrayList<>();
		ArrayList<String> lenguages = new ArrayList<>();
		ArrayList<String> genre = new ArrayList<>();

		lenguages.add("ES");
		lenguages.add("EN");

		genre.add("Drama");

		Book book1 = new Book(authors,"Televisores", lenguages, genre, new Date());

		authorRepositorie.save(author);
		authorRepositorie.save(author2);
		bookRepositorie.save(book1);
		
		System.out.println(book1);
	}


	public void findOne(Long id){

		personRepository.findById(id).ifPresentOrElse(person -> System.out.println(person),
			() -> System.out.println("EL ID INDICADO NO SE ENCUENTRA ASOCIADO A NINGUN USUARIO"));
	
	}


	public void list(){

		List<Person> persons = (List<Person>)personRepository.findAll();
		
		persons.stream().forEach(person -> {
	
			System.out.println(person);
		});
		
	} 

}
