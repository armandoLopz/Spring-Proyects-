package com.armando.pruebas.springboot_practices.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.armando.pruebas.springboot_practices.models.Product;
import com.armando.pruebas.springboot_practices.services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    private final ProductServices productServices;

    public ProductController(ProductServices productServices){

        this.productServices = productServices;
    }

    @GetMapping("showProducts")
    public List<Product> allProducts() {
        return productServices.AllProducts();
    }

    @GetMapping("/id/{number}")
    public Product getProductForId(@PathVariable int number) {

        return productServices.FindById(number);
    }

    @GetMapping("/nameProduct/{nameProduct}")
    public Product getProductForId(@PathVariable String nameProduct) {

        return productServices.FindByName(nameProduct);
    }
    
    @GetMapping("/nameCategorie/{nameCategorie}")
    public List<Product> getProductsForCategorie(@PathVariable String nameCategorie) {

        return productServices.FindProductsByCategorie(nameCategorie);
    }


    @PostMapping("/addProduct")
    public Product createProduct(@RequestBody Product product) {      
        
        return productServices.Addproduct(product);
    }
    
}
