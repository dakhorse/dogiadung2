package com.example.dogiadung.repository;
import com.example.dogiadung.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

