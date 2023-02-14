package com.example.springdatajpa.service;

import com.example.springdatajpa.entities.Product;
import com.example.springdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpli implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {

        Product productData = productRepository.findById(id).get();

        if (Objects.nonNull(product.getName())
                && !"".equalsIgnoreCase(
                product.getName())) {
            productData.setName(
                    product.getName());
        }

        if (Objects.nonNull(
                product.getDescription())
                && !"".equalsIgnoreCase(
                product.getDescription())) {
            productData.setDescription(
                    product.getDescription());
        }

        if (Objects.nonNull(product.getPrice())) {
            productData.setPrice(
                    product.getPrice());
        }
        return productRepository.save(productData);
    }
}
