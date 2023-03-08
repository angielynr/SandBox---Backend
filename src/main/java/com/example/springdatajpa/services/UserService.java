package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.requestDto.UserRequestDTO;
import com.example.springdatajpa.dto.responseDto.UserResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponseDTO> getUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO)  throws RecordNotFoundException;

    void deleteUserById(Long id)  throws RecordNotFoundException ;
}
