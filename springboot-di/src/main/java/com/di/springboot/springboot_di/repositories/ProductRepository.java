package com.di.springboot.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.di.springboot.springboot_di.models.Product;

public class ProductRepository {

    List <Product> data;

    public ProductRepository(){

        this.data = Arrays.asList(
            
            new Product("Televisor", 1L,20L),
            new Product("book", 7L,10L),
            new Product("keyboard", 3L,5L),
            new Product("Puerta", 4L,31L),
            new Product("Regulador", 5L,2L)
        );
        
    }

    public List<Product> findAll(){

        return data;
    }

    public Product findById(Long id){

        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }


}
