package com.example.springdatajpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotNull(message = "Product name shoudn't be null")
    private String name;

    @NotBlank(message = "Product description shoudn't be blank")
    private String description;

    @NotNull(message = "Product price shoudn't be null")
    private Double price;

}
