package com.example.artisan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.artisan.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
