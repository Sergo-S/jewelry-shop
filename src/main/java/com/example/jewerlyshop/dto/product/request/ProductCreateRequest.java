package com.example.jewerlyshop.dto.product.request;

import com.example.jewerlyshop.entity.Kind;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class ProductCreateRequest {

    @NotBlank(message = "The name is required.")
    private String name;

    @NotNull(message = "The price is required.")
    private Double price;


    @NotNull(message = "The quantity is required.")
    private Short quantity;


    @NotNull(message = "The kindId is required.")
    private Long kindId;
}
