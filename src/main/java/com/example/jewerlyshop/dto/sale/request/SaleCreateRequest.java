package com.example.jewerlyshop.dto.sale.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaleCreateRequest {

    @NotNull(message = "The clientId is required.")
    private Long clientId;

    @NotNull(message = "The productId is required.")
    private Long productId;

    @NotNull(message = "The employeeId is required.")
    private Long employeeId;

    @NotNull(message = "The revenue is required.")
    private Double revenue;
}
