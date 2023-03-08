package com.example.springdatajpa.dto.responseDto;

import lombok.Data;

@Data
public class ProductResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;
}
