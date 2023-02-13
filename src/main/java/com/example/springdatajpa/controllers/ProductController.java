package com.example.springdatajpa.controllers;

import com.example.springdatajpa.entities.Product;
import com.example.springdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/get")
    public Iterable<Product> getProducts(){
        return productRepository.findAll();
//        List<Product> result = new ArrayList<Product>();
//        productRepository.findAll().forEach(product -> result.add(product));
//        return result;
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id){
        return productRepository.findById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return  productRepository.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return  productRepository.save(product);
    }


//    @DeleteMapping("/{id}")
//    public Product deleteProductById(@PathVariable("id") Long id){
//        return productRepository.deleteById(id);
//    }
}
