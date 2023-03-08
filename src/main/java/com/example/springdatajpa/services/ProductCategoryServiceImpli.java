package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.requestDto.ProductCategoryRequestDTO;
import com.example.springdatajpa.dto.responseDto.ProductCategoryResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import com.example.springdatajpa.mapper.ProductCategoryMapper;
import com.example.springdatajpa.models.ProductCategory;
import com.example.springdatajpa.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpli implements ProductCategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryResponseDTO> getProductCategories() {

        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return productCategories.stream().map(category -> productCategoryMapper.modelToDto(category)).toList();
    }

    @Override
    public ProductCategoryResponseDTO getProductCategoryById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).get();
        return productCategoryMapper.modelToDto(productCategory);
    }

    @Override
    public ProductCategoryResponseDTO addProductCategory(ProductCategoryRequestDTO productCategoryRequestDTO) {
        ProductCategory productCategory = productCategoryMapper.dtoToModel(productCategoryRequestDTO);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return productCategoryMapper.modelToDto(savedProductCategory);
    }

    @Override
    public ProductCategoryResponseDTO updateProductCategory(Long id, ProductCategoryRequestDTO productCategoryRequestDTO) throws RecordNotFoundException {
        Optional<ProductCategory> productId= productCategoryRepository.findById(id);
        if(productId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }

        ProductCategory productCategoryData = productCategoryRepository.findById(id).get();
        if (Objects.nonNull(productCategoryData.getProductCategory())
                && !"".equalsIgnoreCase(
                productCategoryData.getProductCategory())) {
            productCategoryData.setProductCategory(
                    productCategoryRequestDTO.getProductCategory());
        }

        ProductCategory savedProduct = productCategoryRepository.save(productCategoryData);

        return productCategoryMapper.modelToDto(savedProduct);
    }

    @Override
    public void deleteProductCategoryById(Long id) throws RecordNotFoundException {
        Optional<ProductCategory> productCategoryId = productCategoryRepository.findById(id);
        if(productCategoryId.isEmpty()){
            throw new RecordNotFoundException("Product category not found with id " + id);
        }
        productCategoryRepository.deleteById(id);

    }
}
