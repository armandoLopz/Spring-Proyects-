package com.armando.pruebas.springboot_practices.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    
    private List<Product> shoppingCartList;
    //private User user;
    private int totalAmount;

}
