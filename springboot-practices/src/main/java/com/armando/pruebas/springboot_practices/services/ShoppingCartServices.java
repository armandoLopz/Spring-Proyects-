package com.armando.pruebas.springboot_practices.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.armando.pruebas.springboot_practices.models.ShoppingCart;
import com.armando.pruebas.springboot_practices.models.User;
import com.armando.pruebas.springboot_practices.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartServices {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    public Map<String, ShoppingCart> showAllShoppingCarts() {

        Map <String, ShoppingCart> mapJson = new HashMap<>();
        
        for (Map.Entry<User, ShoppingCart> mapRepository : shoppingCartRepository.showAllShoppingCarts().entrySet()) {

            mapJson.put("Carrito del userId: " + mapRepository.getKey().getId(), mapRepository.getValue());
        }

        return mapJson;
    }
    

    public ResponseEntity<Object> findShoppingCartById(int id){

        ShoppingCart shoppingCart = new ShoppingCart();
        
        shoppingCart = shoppingCartRepository.showAllShoppingCarts().entrySet()
            .stream()
            .filter(entry -> entry.getKey().getId() ==id)
            .map(Map.Entry::getValue)
            .findFirst()
            .orElse(null);

        if (shoppingCart != null) {
            return ResponseEntity.ok(shoppingCart);
        
        } else {
            
            String errorMessage = "No se encontró el carrito de compras para el usuario con ID: " + id;

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }   
    }
}
