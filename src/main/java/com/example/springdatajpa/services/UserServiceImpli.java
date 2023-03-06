package com.example.springdatajpa.services;

import com.example.springdatajpa.dto.UserRequestDTO;
import com.example.springdatajpa.dto.UserResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import com.example.springdatajpa.mapper.UserMapper;
import com.example.springdatajpa.models.User;
import com.example.springdatajpa.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpli implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserResponseDTO> getUsers() {
        List<User> products = userRepository.findAll();
    return products.stream().map(user -> userMapper.modelToDto(user)).toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return userMapper.modelToDto(user);
    }

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.dtoToModel(userRequestDTO);
        User savedUser = userRepository.save(user);
        return userMapper.modelToDto(savedUser);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO)  throws RecordNotFoundException {

        Optional<User> userId= userRepository.findById(id);
        if(userId.isEmpty()){
            throw new RecordNotFoundException("Product not found with id " + id);
        }

        User userData = userRepository.findById(id).get();
        if (Objects.nonNull(userData.getFirstName())
                && !"".equalsIgnoreCase(
                userData.getFirstName())) {
            userData.setFirstName(
                    userRequestDTO.getFirstName());
        }

        if (Objects.nonNull(userData.getLastName())
                && !"".equalsIgnoreCase(
                userData.getLastName())) {
            userData.setLastName(
                    userRequestDTO.getLastName());
        }

        if (Objects.nonNull(
                userData.getEmail())
                && !"".equalsIgnoreCase(
                userData.getEmail())) {
            userData.setEmail(
                    userRequestDTO.getEmail());
        }

        User savedUser = userRepository.save(userData);

        return userMapper.modelToDto(savedUser);
    }

    public void deleteUserById(Long id)  throws RecordNotFoundException {
        Optional<User> userId= userRepository.findById(id);
        if(userId.isEmpty()){
            throw new RecordNotFoundException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
