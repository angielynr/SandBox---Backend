package com.example.springdatajpa.mapper;

import com.example.springdatajpa.dto.ProductDTO;
import com.example.springdatajpa.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO modelToDto(Product product);
    Product dtoToModel(ProductDTO productDTO);
}
