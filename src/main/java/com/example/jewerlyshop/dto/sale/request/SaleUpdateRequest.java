package com.example.jewerlyshop.dto.sale.request;



import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class SaleUpdateRequest {

    @NotNull
    private Double revenue;
}
