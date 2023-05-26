package com.example.jewerlyshop.dto.employee.response;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class EmployeeResponse {
    private Long id;

    private String name;

    private String post;

    private Double salary;

    private LocalDate hireDate;

    private LocalDate birthDate;
}
