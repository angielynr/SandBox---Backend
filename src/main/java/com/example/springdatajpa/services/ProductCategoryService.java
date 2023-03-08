package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.requestDto.ProductCategoryRequestDTO;
import com.example.springdatajpa.dto.responseDto.ProductCategoryResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryService {

    List<ProductCategoryResponseDTO> getProductCategories();

    ProductCategoryResponseDTO getProductCategoryById(Long id);
    ProductCategoryResponseDTO addProductCategory(ProductCategoryRequestDTO productCategoryRequestDTO);
    ProductCategoryResponseDTO updateProductCategory(Long id, ProductCategoryRequestDTO productCategoryRequestDTO) throws RecordNotFoundException;

    void deleteProductCategoryById(Long id) throws RecordNotFoundException;

}
