package com.armando.pruebas.springboot_practices.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}
