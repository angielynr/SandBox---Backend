package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.ProductRequestDTO;
import com.example.springdatajpa.dto.ProductResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductResponseDTO> getProducts();

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO addProduct(ProductRequestDTO product);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO product)  throws RecordNotFoundException;

     void deleteProductById(Long id)  throws RecordNotFoundException ;
}
