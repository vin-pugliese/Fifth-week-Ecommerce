package com.corso.java.service;

import com.corso.java.domain.Product;
import com.corso.java.repository.ProductRepository;
import com.corso.java.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(String id, String description, String name) {
        Optional<Product> x = productRepository.findById(id);
        x.ifPresent(s->{
            s.setNome(name);
            s.setDescription(description);
            productRepository.save(s);
        });
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
        System.out.println("Eliminato prodotto id: " +id);
    }

    @Override
    public void updateQty(String id, Integer qty) {
        Optional<Product> x = productRepository.findById(id);
        x.ifPresent(s->{
            s.setQty(s.getQty()-qty);
            productRepository.save(s);
        });
    }
}
