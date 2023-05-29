package com.example.jewerlyshop.dto.employee.request;

import com.example.jewerlyshop.common.enums.Post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.jewerlyshop.common.validation.BirthDate;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class EmployeeCreateRequest {

    @NotBlank(message = "The name is required.")
    private String name;

    @NotNull(message = "The post is required.")
    private Post post;

    @NotNull(message = "The salary is required.")
    private Double salary;

    @NotNull(message = "The date of birth is required.")
    @BirthDate(message = "The birth date must be greater or equal than 18")
    @Past(message = "The date of birth must be in the past.")
    private LocalDate birthDate;
}
