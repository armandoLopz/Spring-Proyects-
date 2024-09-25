package com.microservice.apartments.microservice_apartments.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "apartment")
@Entity
public class ApartmentEntity {

    @Id
    @Column(name = "apartment_id")
    private Long apartmentId;

    //Relation with table owner in ms Residents
    @Column(name = "owner_id")
    private Long ownerId;

    //Possible type with an enum
    @Column(name = "state_Of_Apartment")
    private String stateOfApartment;
}
