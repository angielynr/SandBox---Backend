package com.example.springdatajpa.controllers;

import com.example.springdatajpa.dto.UserRequestDTO;
import com.example.springdatajpa.dto.UserResponseDTO;
import com.example.springdatajpa.exceptions.RecordNotFoundException;
import com.example.springdatajpa.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getProducts() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> addProduct(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.addUser(userRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateProduct(@PathVariable("id") Long id, @RequestBody UserRequestDTO userRequestDTO) throws RecordNotFoundException {
        return new ResponseEntity<>(userService.updateUser(id, userRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) throws RecordNotFoundException{
        userService.deleteUserById(id);
        return new ResponseEntity<>("Product Successfully Deleted", HttpStatus.OK);
    }
}
