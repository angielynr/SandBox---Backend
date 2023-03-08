package com.example.springdatajpa.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AllProductResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;

    @JsonProperty("category")
    private ProductCategoryResponseDTO productCategory;
}
