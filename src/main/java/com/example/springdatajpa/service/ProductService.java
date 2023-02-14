package com.example.springdatajpa.service;

import com.example.springdatajpa.entities.Product;

import java.util.List;

public interface ProductService {

    // Read operation
    Iterable<Product> getProducts();

    // Save operation
    Product addProduct(Product product);

    // Update operation
    Product updateProduct(Product product, Long id);

    // Delete operation
//    void deleteProductById(Long id);
}
