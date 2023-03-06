package com.example.springdatajpa.repositories;

import com.example.springdatajpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
