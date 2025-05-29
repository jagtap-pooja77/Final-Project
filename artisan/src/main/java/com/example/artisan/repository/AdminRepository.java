package com.example.artisan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.artisan.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
