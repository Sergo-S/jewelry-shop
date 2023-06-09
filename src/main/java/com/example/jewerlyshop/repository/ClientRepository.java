package com.example.jewerlyshop.repository;

import com.example.jewerlyshop.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByName(String name);

}
