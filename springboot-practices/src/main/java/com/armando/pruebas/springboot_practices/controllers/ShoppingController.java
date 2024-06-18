package com.armando.pruebas.springboot_practices.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armando.pruebas.springboot_practices.models.Product;
import com.armando.pruebas.springboot_practices.models.ShoppingCart;
import com.armando.pruebas.springboot_practices.services.ShoppingCartServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController

@RequestMapping("/user/{id}")
public class ShoppingController {

    @Autowired
    private ShoppingCartServices shoppingCartServices;
    
    @GetMapping("/cart")
    public ResponseEntity<Object> findCartByIdUser(@PathVariable int id) {

        return shoppingCartServices.findShoppingCartById(id);
    }

    @GetMapping("/addProduct/{idProduct}")
    public Product addProduct(@PathVariable int idProduct) {

        return null;
    }
    
    @GetMapping("/sh")
    public Map<String, ShoppingCart> allShoppingCarts() {
        return shoppingCartServices.showAllShoppingCarts();
    }
    
}