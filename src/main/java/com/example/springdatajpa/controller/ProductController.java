package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.ProductDTO;
import com.example.springdatajpa.exception.RecordNotFoundException;
import com.example.springdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "Successfully Deleted";
    }
}
