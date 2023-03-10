package com.example.springdatajpa.controllers;

import com.example.springdatajpa.dto.requestDto.ProductRequestDTO;
import com.example.springdatajpa.dto.responseDto.AllProductResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import com.example.springdatajpa.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<AllProductResponseDTO>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllProductResponseDTO> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AllProductResponseDTO> addProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.addProduct(productRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AllProductResponseDTO> updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductRequestDTO productRequestDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(id, productRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) throws RecordNotFoundException{
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product Successfully Deleted", HttpStatus.OK);
    }
}
