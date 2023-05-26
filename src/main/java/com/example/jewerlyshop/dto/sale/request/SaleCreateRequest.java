package com.example.jewerlyshop.dto.sale.request;

import com.sun.istack.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaleCreateRequest {

    @NotNull
    private Long clientId;

    @NotNull
    private Long productId;

    @NotNull
    private Long employeeId;

    @NotNull
    private Double revenue;
}
