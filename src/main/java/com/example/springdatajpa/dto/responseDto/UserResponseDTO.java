package com.example.springdatajpa.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    protected String createdBy;
    protected Date createdDate;
    protected String lastModifiedBy;
    protected Date lastModifiedDate;

}
