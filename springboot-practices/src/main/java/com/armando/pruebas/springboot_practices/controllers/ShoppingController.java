package com.armando.pruebas.springboot_practices.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armando.pruebas.springboot_practices.models.Product;
import com.armando.pruebas.springboot_practices.models.ShoppingCart;
import com.armando.pruebas.springboot_practices.services.ProductServices;
import com.armando.pruebas.springboot_practices.services.ShoppingCartServices;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
//@RequestMapping("/user/{userId}/shopping")
@RequestMapping("/all")
public class ShoppingController {

    @Autowired
    private ProductServices productServices;
    
    @Autowired
    private ShoppingCartServices shoppingCartServices;
    @GetMapping("")
    public List<Product> productsList() {
        
        return productServices.AllProducts();
    }

    @GetMapping("/sh")
    public Map<String, ShoppingCart> allShoppingCarts() {
        return shoppingCartServices.showAllShoppingCarts();
    }
    
}