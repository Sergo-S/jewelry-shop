package com.example.jewerlyshop.repository;

import com.example.jewerlyshop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
