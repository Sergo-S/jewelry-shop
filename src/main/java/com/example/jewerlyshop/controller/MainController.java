package com.example.jewerlyshop.controller;

import com.example.jewerlyshop.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.jewerlyshop.entity.Client;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class MainController {

    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final KindService kindService;
    private final ProductService productService;
    private final SaleService saleService;


}
