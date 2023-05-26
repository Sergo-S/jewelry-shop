package com.example.jewerlyshop.dto.employee.request;

import com.example.jewerlyshop.common.enums.Post;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class EmployeeCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private Post post;

    @NotNull
    private Double salary;

    @NotNull
    private LocalDate birthDate;
}
