package com.example.jewerlyshop.dto.product.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductUpdateRequest {

    @NotBlank(message = "The name is required.")
    private String name;

    @NotNull(message = "The price is required.")
    private Double price;

    @NotNull(message = "The quantity is required.")
    private Short quantity;
}
