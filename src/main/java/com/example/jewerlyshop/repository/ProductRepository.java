package com.example.jewerlyshop.repository;

import com.example.jewerlyshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByKindId(Long id);
}
