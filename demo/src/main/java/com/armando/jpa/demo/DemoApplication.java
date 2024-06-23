package com.armando.jpa.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.armando.jpa.demo.entities.Person;
import com.armando.jpa.demo.repositories.PersonRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Person> persons = (List<Person>)personRepository.findAll();

		persons.stream().forEach(person -> {

			System.out.println(person);
		});
	}

}
