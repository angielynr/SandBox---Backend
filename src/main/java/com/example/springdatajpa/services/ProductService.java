package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.ProductDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDTO> getProducts();

    ProductDTO getProductById(Long id);

    ProductDTO addProduct(ProductDTO product);

    ProductDTO updateProduct(Long id, ProductDTO product)  throws RecordNotFoundException;

     void deleteProductById(Long id)  throws RecordNotFoundException ;
}
