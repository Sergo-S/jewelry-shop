package com.example.jewerlyshop.dto.sale.response;

import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.dto.employee.response.EmployeeResponse;
import com.example.jewerlyshop.dto.product.response.ProductResponse;
import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.entity.Employee;
import com.example.jewerlyshop.entity.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaleResponse {
    private Long id;
    private Long clientId;
    private Long productId;
    private Long employeeId;
    private LocalDate date;
    private Double revenue;
}
