package com.armando.pruebas.springboot_practices.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armando.pruebas.springboot_practices.models.Product;

@Repository
public class ProductRepository {

    private List<Product> inventoryListProduct = new ArrayList<>(); 

    public void instanceList(){

        inventoryListProduct.add(new Product(1,10,"Televisor Samsung","Tecnologia",200));
        inventoryListProduct.add(new Product(12,10,"Telefono Samsung","Tecnologia",12));
        inventoryListProduct.add(new Product(14,10,"Monitor","Tecnologia",32.43));
        inventoryListProduct.add(new Product(85,10,"Cobija","Casa",10.324));
        inventoryListProduct.add(new Product(7,10,"Cama","Casa",50));
        inventoryListProduct.add(new Product(47,10,"Lamparas","Luces",47.5));
        inventoryListProduct.add(new Product(4,10,"Carne","Alimento",10));
        inventoryListProduct.add(new Product(5,10,"Redmi 9","Telefonos",300.50));

    }

    public ProductRepository(){

        instanceList();
    }

    public List<Product>inventoryProducts(){
        
        return inventoryListProduct;
    }

    public Product addProduct(Product product){
        
        inventoryListProduct.add(product);

        return product;
    }
}
