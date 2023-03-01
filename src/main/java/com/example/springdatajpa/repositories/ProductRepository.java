package com.example.springdatajpa.repositories;

import com.example.springdatajpa.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

   List<Product> findByName(String name); //for testClass
}
