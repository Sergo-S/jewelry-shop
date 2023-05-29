package com.example.jewerlyshop.controller;

import com.example.jewerlyshop.dto.kind.request.KindUpdateRequest;
import com.example.jewerlyshop.dto.kind.response.KindResponse;
import com.example.jewerlyshop.dto.product.request.ProductCreateRequest;
import com.example.jewerlyshop.dto.product.response.ProductResponse;
import com.example.jewerlyshop.dto.sale.request.SaleCreateRequest;
import com.example.jewerlyshop.dto.sale.request.SaleUpdateRequest;
import com.example.jewerlyshop.dto.sale.response.SaleResponse;
import com.example.jewerlyshop.mapper.SaleMapper;
import com.example.jewerlyshop.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/sale")
public class SaleController {

    private final SaleService saleService;
    private final SaleMapper saleMapper;
    @GetMapping("/getAll")
    public List<SaleResponse> getAllSales(){
        return saleService.getAllSales().stream().map(saleMapper::toDto).toList();

    }
    @GetMapping("/id/{id}")
    public SaleResponse getById(@PathVariable Long id){
        return saleMapper.toDto(saleService.getSaleById(id));
    }

    @PostMapping("/create")
    public SaleResponse create(@Valid @RequestBody SaleCreateRequest saleDto) {
        return saleMapper.toDto(saleService.create(saleMapper.fromDto(saleDto),
                saleDto.getClientId(),saleDto.getProductId(),saleDto.getEmployeeId()));
    }

    @PutMapping("/update/{id}")
    public SaleResponse update(@Valid @RequestBody SaleUpdateRequest saleDto,@PathVariable Long id){
        return saleMapper.toDto((saleService.update(saleMapper.fromDto(saleDto),id)));
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        saleService.deleteById(id);
    }
}
