package com.corso.java.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Document(collection = "cart")
public class Cart {

    @Id
    private String id;

    private List<Product> products;

    public Cart(){
        products = new ArrayList<Product>();
    }

}
