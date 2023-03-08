package com.example.springdatajpa.mapper;

import com.example.springdatajpa.dto.requestDto.ProductRequestDTO;
import com.example.springdatajpa.dto.responseDto.AllProductResponseDTO;
import com.example.springdatajpa.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    AllProductResponseDTO modelToDto(Product product);
    Product dtoToModel(ProductRequestDTO productRequestDTO);

}
