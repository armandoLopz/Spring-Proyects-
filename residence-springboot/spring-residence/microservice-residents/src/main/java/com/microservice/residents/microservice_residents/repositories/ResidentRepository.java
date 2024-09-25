package com.microservice.residents.microservice_residents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.residents.microservice_residents.entities.ResidentEntity;

@Repository
public interface ResidentRepository extends CrudRepository<ResidentEntity, Long>{

}
