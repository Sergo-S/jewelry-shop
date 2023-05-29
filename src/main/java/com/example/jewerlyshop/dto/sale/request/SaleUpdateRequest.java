package com.example.jewerlyshop.dto.sale.request;



import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class SaleUpdateRequest {

    @NotNull(message = "The revenue is required.")
    private Double revenue;
}
