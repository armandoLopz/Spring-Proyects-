package com.armando.jpa.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.armando.jpa.demo.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    
    
}
