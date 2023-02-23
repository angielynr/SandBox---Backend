package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> getProducts();

    Optional<Product> getProductById(Long id);

    Product addProduct(Product product);

    Product updateProduct(Long id, Product product);

     void deleteProductById(Long id);
}
