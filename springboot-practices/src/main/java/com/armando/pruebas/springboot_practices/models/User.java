package com.armando.pruebas.springboot_practices.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    
    private String name, lastname, correo;
    private int age, id;



}
