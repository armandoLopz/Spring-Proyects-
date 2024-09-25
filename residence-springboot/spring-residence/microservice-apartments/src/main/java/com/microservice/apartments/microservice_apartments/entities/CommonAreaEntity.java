package com.microservice.apartments.microservice_apartments.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "common_area")
@Entity
public class CommonAreaEntity {

    @Id
    @Column(name = "area_id")
    private Long areaID;

    @Column(name = "name_id")
    private String nameArea;

    @Column(name = "area_description")
    private String descriptionArea;

    @Column(name = "area_cost")
    private float costArea;

    @Column(name = "open_time")
    private Date openTime;

    @Column(name = "close_time")
    private Date closeTime;
}
