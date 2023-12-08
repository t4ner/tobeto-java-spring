package com.spring.homework.controllers;

import com.spring.homework.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    List<Product> inProductsList = new ArrayList<>();

    @GetMapping // api/persons ile çalışır.
    public List<Product> get(){
        return inProductsList;
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id){
        Product product = inProductsList.stream().filter((p) -> p.getId() == id).findFirst().orElseThrow();
        return product;
    }

    @PostMapping
    public String add(@RequestBody Product product) {
        inProductsList.add(product);
        return product.getId()+" ID' li ürün sisteme eklendi.";
    }

    @PutMapping
    public String update(@RequestBody Product updatedProduct){
        Product product = inProductsList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == updatedProduct.getId()) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        return product.getId()+" ID' li ürün güncellendi.";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        Product product = inProductsList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == id) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        inProductsList.remove(product);
        return id+" ID' li ürün silindi.";
    }


}
