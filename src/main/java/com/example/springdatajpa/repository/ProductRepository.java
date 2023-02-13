package com.example.springdatajpa.repository;

import com.example.springdatajpa.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

   List<Product> findByName(String name);
}
