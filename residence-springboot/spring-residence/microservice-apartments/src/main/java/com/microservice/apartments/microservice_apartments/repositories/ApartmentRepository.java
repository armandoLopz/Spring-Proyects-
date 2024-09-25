package com.microservice.apartments.microservice_apartments.repositories;

import org.springframework.data.repository.CrudRepository;

import com.microservice.apartments.microservice_apartments.entities.ApartmentEntity;

public interface ApartmentRepository extends CrudRepository<ApartmentEntity, Long> {

}
