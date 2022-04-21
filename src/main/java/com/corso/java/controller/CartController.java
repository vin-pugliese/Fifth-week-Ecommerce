package com.corso.java.controller;

import com.corso.java.domain.Cart;
import com.corso.java.domain.Product;
import com.corso.java.service.api.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/ecommerce/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    ResponseEntity<List<Cart>> getAll(){
        List<Cart> carts = cartService.findAll();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    ResponseEntity<Cart> getById(@PathVariable String id){
        Optional<Cart> cart = cartService.findById(id);
        return new ResponseEntity<Cart>((Cart) cartService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Cart> save(@RequestBody Cart cart){
        Cart cart1 = cartService.create(cart);
        return new ResponseEntity<>(cart1, HttpStatus.OK);
    }

    @PostMapping(path="/add")
    //ResponseEntity<Void> addProduct(@RequestParam String idcart, @RequestParam String idprod, @RequestParam Integer qty){
    ResponseEntity<Void> addProduct(@RequestParam  String idcart, @RequestBody Product product){
        //cartService.addProduct(idcart, idprod, qty);
        System.out.println("controller: " +product.toString());
        cartService.addProduct(idcart, product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(path="/checkout/{id}")
    ResponseEntity<Void> checkout(@PathVariable String id){
        cartService.checkout(id);
        System.out.println("ciomprato");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}

//62614badb5bfcd5b04494bc2
//62614bbab5bfcd5b04494bc3

//cartID 62614ed5c27d0646e30ef0b6

