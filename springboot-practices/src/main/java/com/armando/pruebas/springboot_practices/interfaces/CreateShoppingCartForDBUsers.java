package com.armando.pruebas.springboot_practices.interfaces;

import java.util.Map;

import com.armando.pruebas.springboot_practices.models.ShoppingCart;
import com.armando.pruebas.springboot_practices.models.User;

public interface CreateShoppingCartForDBUsers {
    
    public abstract Map<User, ShoppingCart> createShoppingCartForUserDB();
}
