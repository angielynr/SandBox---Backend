package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.ProductDTO;
import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpli implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
    return productDTOs;
//        return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);
        ProductDTO savedProductDto = modelMapper.map(savedProduct, ProductDTO.class);
        return savedProductDto;
    }

    @Override
    public ProductDTO updateProduct(Long id ,ProductDTO product) {

        Product productData = productRepository.findById(id).get();

        if (Objects.nonNull(productData.getName())
                && !"".equalsIgnoreCase(
                productData.getName())) {
            productData.setName(
                    product.getName());
        }

        if (Objects.nonNull(
                productData.getDescription())
                && !"".equalsIgnoreCase(
                productData.getDescription())) {
            productData.setDescription(
                    product.getDescription());
        }

        if (Objects.nonNull(productData.getPrice())) {
            productData.setPrice(
                    product.getPrice());
        }

        Product savedProduct = productRepository.save(productData);
        ProductDTO productDTO = modelMapper.map(savedProduct, ProductDTO.class);

        return productDTO;
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
