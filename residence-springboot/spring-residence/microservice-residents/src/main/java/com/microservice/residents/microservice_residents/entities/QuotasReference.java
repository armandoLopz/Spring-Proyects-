package com.microservice.residents.microservice_residents.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//This entity is used to create a relationship with the residents / owners
//The objective the this entity is save the all quotas id has the residents / owners

@Entity
@Table(name = "quotas_reference")
public class QuotasReference {

    @Id
    private Long quotas_id;
    
    @ManyToOne
    @JoinColumn(name="resident_Id", nullable=false)
    private ResidentEntity residents;
}
