package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.requestDto.ProductRequestDTO;
import com.example.springdatajpa.dto.responseDto.AllProductResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<AllProductResponseDTO> getProducts();

    AllProductResponseDTO getProductById(Long id);

    AllProductResponseDTO addProduct(ProductRequestDTO product);

    AllProductResponseDTO updateProduct(Long id, ProductRequestDTO product)  throws RecordNotFoundException;

     void deleteProductById(Long id)  throws RecordNotFoundException ;
}
