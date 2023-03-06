package com.example.springdatajpa.mapper;

import com.example.springdatajpa.dto.UserRequestDTO;
import com.example.springdatajpa.dto.UserResponseDTO;
import com.example.springdatajpa.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO modelToDto(User user);
    User dtoToModel(UserRequestDTO userRequestDTO);
}
