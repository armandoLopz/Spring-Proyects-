package com.armando.pruebas.springboot_practices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.armando.pruebas.springboot_practices.models.Product;
import com.armando.pruebas.springboot_practices.repositories.ProductRepository;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product Addproduct(Product product){

        return productRepository.addProduct(product);
    }

    public Product FindById(int id){
        
        return productRepository.inventoryProducts().stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .get();
    }

    public List<Product> AllProducts(){

        return productRepository.inventoryProducts();
    }

    public Product FindByName(String name){

        return productRepository.inventoryProducts().stream()
        .filter(p -> p.getName().toLowerCase().trim().equals(name.toLowerCase().trim()) == true)
        .findFirst()
        .get();
    }

    public List<Product> FindProductsByCategorie(String categorie){

        return productRepository.inventoryProducts().stream()
        .filter(p -> p.getCategorie().toLowerCase().trim().equals(categorie.toLowerCase().trim()) == true)
        .toList();

    }
}
