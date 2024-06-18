package com.armando.pruebas.springboot_practices.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import com.armando.pruebas.springboot_practices.models.Product;
import com.armando.pruebas.springboot_practices.models.ShoppingCart;
import com.armando.pruebas.springboot_practices.models.User;

@Repository
@SessionScope
public class ShoppingCartRepository {
    
    @Autowired
    private Map<User, ShoppingCart> usersCarts = new HashMap<>();    
    
    public Map<User, ShoppingCart> createShoppingCart(User user){

        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> productsList = new ArrayList<>();
        
        //shoppingCart.setUser(user);
        shoppingCart.setShoppingCartList(productsList);
        shoppingCart.setTotalAmount(0);

        usersCarts.put(user, shoppingCart);

        return usersCarts;
    }

    public Map<User, ShoppingCart> showAllShoppingCarts(){

        return usersCarts;
    }
}
