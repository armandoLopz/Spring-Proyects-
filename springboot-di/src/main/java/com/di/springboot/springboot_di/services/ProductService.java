package com.di.springboot.springboot_di.services;

import java.util.List;

import com.di.springboot.springboot_di.models.Product;
import com.di.springboot.springboot_di.repositories.ProductRepository;

public class ProductService {
    
    private ProductRepository productRepository = new ProductRepository();

    public ProductService(){

    }

    public List<Product> findAll(){

        return productRepository.findAll();
    }

    public Product findById(Long id){

        return productRepository.findById(id);
    }
}
