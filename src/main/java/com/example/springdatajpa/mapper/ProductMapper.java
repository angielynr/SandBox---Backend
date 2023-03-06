package com.example.springdatajpa.mapper;

import com.example.springdatajpa.dto.ProductRequestDTO;
import com.example.springdatajpa.dto.ProductResponseDTO;
import com.example.springdatajpa.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO modelToDto(Product product);
    Product dtoToModel(ProductRequestDTO productRequestDTO);
}
