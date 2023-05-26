package com.example.jewerlyshop.service;


import com.example.jewerlyshop.entity.Kind;
import com.example.jewerlyshop.entity.Product;
import com.example.jewerlyshop.entity.Sale;
import com.example.jewerlyshop.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final ClientService clientService;
    private final ProductService productService;
    private final EmployeeService employeeService;

    public Sale create (Sale sale, Long clientId, Long productId, Long employeeId){
        sale.setClient(clientService.getClientById(clientId));
        sale.setProduct(productService.getProductById(productId));
        sale.setEmployee(employeeService.getEmployeeById(employeeId));
        sale.setDate(LocalDate.now());
        return saleRepository.save(sale);
    }

    public Sale update (Sale sale,Long id){

        Sale saleOld = getSaleById(id);

        saleOld.setRevenue(sale.getRevenue());
        return saleRepository.save(saleOld);
    }
    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The sale not found by Id " + id));
    }

    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}
