package com.example.jewerlyshop.repository;

import com.example.jewerlyshop.entity.Product;
import com.example.jewerlyshop.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale,Long> {
    Optional<Sale> findByClientId(Long id);
    Optional<Sale> findByEmployeeId(Long id);
    Optional<Sale> findByProductId(Long id);
}
