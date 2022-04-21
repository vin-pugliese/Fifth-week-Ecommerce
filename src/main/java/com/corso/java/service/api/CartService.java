package com.corso.java.service.api;

import com.corso.java.domain.Cart;
import com.corso.java.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CartService {

    List<Cart> findAll();

    Optional<Cart> findById(String id);

    Cart create(Cart cart);

    void update(String id);

    void delete(String id);

    //void addProduct(String idcart,  String idProd, Integer qty);
    void addProduct(String idcart, Product product);

    void checkout(String id);




}
