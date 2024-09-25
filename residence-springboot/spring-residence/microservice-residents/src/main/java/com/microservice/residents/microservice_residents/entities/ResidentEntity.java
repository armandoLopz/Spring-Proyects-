package com.microservice.residents.microservice_residents.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "resident")
@Entity
@Data
public class ResidentEntity {

    //Relation with table user in microservice-users   
    @Id
    @Column(name = "resident_id")
    private Long resident_Id;

    @ManyToMany
    @JoinTable(
            name = "residents_apartments",
            joinColumns = @JoinColumn(name = "resident_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id")
    )
    private Set<ApartmentReference> apartments;

    @OneToMany(mappedBy = "quotas_id")
    @Column(name = "quotas_id")
    private Set<QuotasReference> quotas;
}
