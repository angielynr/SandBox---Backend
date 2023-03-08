package com.example.springdatajpa.dto.requestDto;

import com.example.springdatajpa.models.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotNull(message = "Product name shouldn't be null")
    private String name;

    @NotBlank(message = "Product description shouldn't be blank")
    private String description;

    @NotNull(message = "Product price shouldn't be null")
    private Double price;

    @NotNull(message = "Product category shouldn't be null")
    private ProductCategoryRequestDTO productCategory;
}
