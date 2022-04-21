package com.corso.java.controller;

import com.corso.java.domain.Product;
import com.corso.java.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ecommerce/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getById(@PathVariable String id){
        Optional<Product> product = productService.findById(id);
        return new ResponseEntity<Product>((Product) productService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Product> save(@RequestBody Product product){
        Product product1 = productService.create(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<?> update(@RequestParam String id, @RequestParam String name, @RequestParam String description){
        productService.update(id, description, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deleteById(@PathVariable String id){
        productService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
