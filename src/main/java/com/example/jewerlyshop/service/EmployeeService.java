package com.example.jewerlyshop.service;

import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.entity.Employee;
import com.example.jewerlyshop.repository.EmployeeRepository;
import com.example.jewerlyshop.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final SaleRepository saleRepository;

    public Employee create (Employee employee){
//        if(Period.between(employee.getBirthDate(),LocalDate.now()).getYears() < 18){
//
//        }
        employee.setHireDate(LocalDate.now());
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee,Long id){
        Employee employeeOld = getEmployeeById(id);

        employeeOld.setName(employee.getName());
        employeeOld.setPost(employee.getPost());
        employeeOld.setSalary(employee.getSalary());
        employeeOld.setBirthDate(employee.getBirthDate());

        return employeeRepository.save(employeeOld);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The employee not found by Id " + id));
    }

    public void deleteById(Long id) {
        saleRepository.findByEmployeeId(id).ifPresent(s -> {
            s.setEmployee(null);
            saleRepository.save(s);
        });

        employeeRepository.deleteById(id);
    }
}
