package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.ProductRequestDTO;
import com.example.springdatajpa.dto.ProductResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import com.example.springdatajpa.mapper.ProductMapper;
import com.example.springdatajpa.models.Product;
import com.example.springdatajpa.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpli implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductResponseDTO> getProducts() {
        List<Product> products = productRepository.findAll();
    return products.stream().map(product -> productMapper.modelToDto(product)).toList();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).get();
        return productMapper.modelToDto(product);
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDto) {
        Product product = productMapper.dtoToModel(productRequestDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.modelToDto(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id , ProductRequestDTO productRequestDto) throws RecordNotFoundException {

        Optional<Product> productId= productRepository.findById(id);
        if(productId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }

        Product productData = productRepository.findById(id).get();
        if (Objects.nonNull(productData.getName())
                && !"".equalsIgnoreCase(
                productData.getName())) {
            productData.setName(
                    productRequestDto.getName());
        }

        if (Objects.nonNull(
                productData.getDescription())
                && !"".equalsIgnoreCase(
                productData.getDescription())) {
            productData.setDescription(
                    productRequestDto.getDescription());
        }

        if (Objects.nonNull(productData.getPrice())) {
            productData.setPrice(
                    productRequestDto.getPrice());
        }

        Product savedProduct = productRepository.save(productData);

        return productMapper.modelToDto(savedProduct);
    }

    public void deleteProductById(Long id)  throws RecordNotFoundException {
        Optional<Product> productId= productRepository.findById(id);
        if(productId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }
}
