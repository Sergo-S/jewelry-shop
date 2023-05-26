package com.example.jewerlyshop.dto.product.request;

import com.example.jewerlyshop.entity.Kind;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class ProductCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private Double price;


    @NotNull
    private Short quantity;


    @NotNull
    private Long kindId;
}
