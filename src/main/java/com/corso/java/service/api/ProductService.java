package com.corso.java.service.api;

import com.corso.java.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Product create(Product product);

    Optional<Product> findById(String id);

    void update(String id, String description, String name);

    void delete(String id);

    void updateQty(String id, Integer qty);


}
