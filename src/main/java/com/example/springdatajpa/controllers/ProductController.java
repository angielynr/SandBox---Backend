package com.example.springdatajpa.controllers;

import com.example.springdatajpa.entities.Product;
import com.example.springdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Iterable<Product> getProducts() {
        return productService.getProducts();
//        List<Product> result = new ArrayList<Product>();
//        productRepository.findAll().forEach(product -> result.add(product));
//        return result;
    }

//    @GetMapping("/{id}")
//    public Optional<Product> getProductById(@PathVariable("id") Long id){
//        return productRepository.findById(id);
//    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return productService.updateProduct(product, id);
    }


//    @DeleteMapping("/{id}")
//    public Product deleteProductById(@PathVariable("id") Long id){
//        return productRepository.deleteById(id);
//    }
}
