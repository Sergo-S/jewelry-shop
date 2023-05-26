package com.example.jewerlyshop.dto.product.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProductUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Short quantity;
}
