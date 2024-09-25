package com.microservice.residents.microservice_residents.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//NOTE: DELETE THIS MICROSERVICE WHEN ALL RUNNING 

@Table(name = "owner")
@Entity
public class OwnerEntity {

    //Relation with table user in microservice-users
    @Id
    @Column(name = "owner_id")
    private Long owner_Id;

    //In apartments and quotas try to use union tables to register a lot of datos a register

    //Change Data type in Set
    @Column(name = "apartments_id")
    private String apartments;
    
    //Change Data type in Set
    @Column(name = "quotas_id")
    private String quotas;
}
