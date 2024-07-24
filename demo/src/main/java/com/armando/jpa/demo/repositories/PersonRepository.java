package com.armando.jpa.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.armando.jpa.demo.entities.Person;
import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByProgrammingLenguaje(String programmingLenguaje);

    @Query("select person from Person person where person.programmingLenguaje = ?1")
    List<Person> findByProgrammingLenguajeName(String programmingLenguaje);
    
}
