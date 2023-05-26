package com.example.jewerlyshop.mapper;

import com.example.jewerlyshop.dto.client.request.ClientUpdateRequest;
import com.example.jewerlyshop.dto.employee.request.EmployeeCreateRequest;
import com.example.jewerlyshop.dto.employee.request.EmployeeUpdateRequest;
import com.example.jewerlyshop.dto.employee.response.EmployeeResponse;
import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.entity.Employee;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(imports = LocalDate.class)
public interface EmployeeMapper {
    Employee fromDto(EmployeeCreateRequest dto);
    Employee fromDto(EmployeeUpdateRequest dto);
    EmployeeResponse toDto(Employee entity);
}
