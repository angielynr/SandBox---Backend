package com.example.springdatajpa.service;

import com.example.springdatajpa.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Read operation
    Iterable<Product> getProducts();

    Optional<Product> getProductById(Long id);

    // Save operation
    Product addProduct(Product product);

    // Update operation
    Product updateProduct(Long id, Product product);

//     Delete operation
     void deleteProductById(Long id);
}
