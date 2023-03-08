package com.example.springdatajpa.mapper;

import com.example.springdatajpa.dto.requestDto.ProductCategoryRequestDTO;
import com.example.springdatajpa.dto.responseDto.ProductCategoryResponseDTO;
import com.example.springdatajpa.models.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {

    ProductCategoryResponseDTO modelToDto(ProductCategory productCategory);
    ProductCategory dtoToModel(ProductCategoryRequestDTO productCategoryRequestDTO);
}
