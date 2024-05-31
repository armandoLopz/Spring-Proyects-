package com.armando.pruebas.springboot_practices.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Product {
    
    private int id, amount;
    private String name,categorie;
    private double price;
}
