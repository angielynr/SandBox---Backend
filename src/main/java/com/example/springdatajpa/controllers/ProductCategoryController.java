package com.example.springdatajpa.controllers;

import com.example.springdatajpa.dto.requestDto.ProductCategoryRequestDTO;

import com.example.springdatajpa.dto.responseDto.ProductCategoryResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import com.example.springdatajpa.services.ProductCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-categories")
@CrossOrigin
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategoryResponseDTO>> getProductCategories() {
        return new ResponseEntity<>(productCategoryService.getProductCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productCategoryService.getProductCategoryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductCategoryResponseDTO> addProduct(@RequestBody @Valid ProductCategoryRequestDTO productCategoryRequestDTO) {
        return new ResponseEntity<>(productCategoryService.addProductCategory(productCategoryRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductCategoryRequestDTO productCategoryRequestDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(productCategoryService.updateProductCategory(id, productCategoryRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) throws RecordNotFoundException{
        productCategoryService.deleteProductCategoryById(id);
        return new ResponseEntity<>("Product Successfully Deleted", HttpStatus.OK);
    }
}
