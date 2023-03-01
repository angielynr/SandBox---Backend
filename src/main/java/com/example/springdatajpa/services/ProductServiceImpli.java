package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.ProductDTO;
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
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
//        List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
    return products.stream().map(product -> productMapper.modelToDto(product)).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).get();
//        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productMapper.modelToDto(product);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);
//        ProductDTO savedProductDto = modelMapper.map(savedProduct, ProductDTO.class);
        return productMapper.modelToDto(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id ,ProductDTO productDto) throws RecordNotFoundException {

        Optional<Product> productId= productRepository.findById(id);
        if(productId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }

        Product productData = productRepository.findById(id).get();
        if (Objects.nonNull(productData.getName())
                && !"".equalsIgnoreCase(
                productData.getName())) {
            productData.setName(
                    productDto.getName());
        }

        if (Objects.nonNull(
                productData.getDescription())
                && !"".equalsIgnoreCase(
                productData.getDescription())) {
            productData.setDescription(
                    productDto.getDescription());
        }

        if (Objects.nonNull(productData.getPrice())) {
            productData.setPrice(
                    productDto.getPrice());
        }

        Product savedProduct = productRepository.save(productData);
//        ProductDTO productDTO = modelMapper.map(savedProduct, ProductDTO.class);

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
