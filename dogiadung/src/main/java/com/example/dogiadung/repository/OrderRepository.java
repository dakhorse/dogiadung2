package com.example.dogiadung.repository;
import com.example.dogiadung.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

