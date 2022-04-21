package com.corso.java.service;

import com.corso.java.domain.Cart;
import com.corso.java.domain.Product;
import com.corso.java.repository.CartRepository;
import com.corso.java.service.api.CartService;
import com.corso.java.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

   @Autowired
   CartRepository cartRepository;

   @Autowired
   ProductService productService;


    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(String id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void update(String id) {
        //todo
    }

    @Override
    public void delete(String id) {
        cartRepository.deleteById(id);;
    }

    @Override
    public void addProduct(String idcart, String idProd, Integer qty, Product x) {
        Optional<Cart> cart = cartRepository.findById(idcart);
        cart.ifPresent(s->{
            Optional<Product> product = productService.findById(idProd);
            product.ifPresent(z->{
                z.setQty(qty);
                s.getProducts().add(z);
                cartRepository.save(s);
                for(Product p: s.getProducts())         //test
                    System.out.println(p.toString());
            });

        });
    }

    @Override
    public void checkout(String id) {
        Optional<Cart> cart = cartRepository.findById(id);
        cart.ifPresent(s->{
            for(Product p: s.getProducts())
                productService.updateQty(p.getId(), p.getQty());
            s.getProducts().removeAll(s.getProducts());
            cartRepository.save(s);
        });
    }
}
