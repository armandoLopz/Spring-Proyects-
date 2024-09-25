package com.microservice.residents.microservice_residents.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//This entity is used to create a relationship with the residents / owners
//The objective the this entity is save the all apartment id has the residents / owners

@Entity
@Table(name = "apartments_reference")
public class ApartmentReference {

    @Id
    private Long apartment_id;
    
    @ManyToMany(mappedBy = "apartments")
    private Set<ResidentEntity> residents;
}
