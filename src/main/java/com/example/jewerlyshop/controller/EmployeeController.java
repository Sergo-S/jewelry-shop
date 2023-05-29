package com.example.jewerlyshop.controller;


import com.example.jewerlyshop.dto.client.request.ClientUpdateRequest;
import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.dto.employee.request.EmployeeCreateRequest;
import com.example.jewerlyshop.dto.employee.request.EmployeeUpdateRequest;
import com.example.jewerlyshop.dto.employee.response.EmployeeResponse;
import com.example.jewerlyshop.entity.Employee;
import com.example.jewerlyshop.mapper.EmployeeMapper;
import com.example.jewerlyshop.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/getAll")
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees().stream().map(employeeMapper::toDto).toList();
    }

    @GetMapping("/id/{id}")
    public EmployeeResponse getById(@PathVariable Long id){
        return employeeMapper.toDto(employeeService.getEmployeeById(id));
    }

    @PostMapping("/create")
    public EmployeeResponse create(@Valid @RequestBody EmployeeCreateRequest employeeDto) {
        return employeeMapper.toDto(employeeService.create(employeeMapper.fromDto(employeeDto)));
    }

    @PutMapping("/update/{id}")
    public EmployeeResponse update(@Valid @RequestBody EmployeeUpdateRequest employeeDto, @PathVariable Long id){
        return employeeMapper.toDto((employeeService.update(employeeMapper.fromDto(employeeDto),id)));
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
