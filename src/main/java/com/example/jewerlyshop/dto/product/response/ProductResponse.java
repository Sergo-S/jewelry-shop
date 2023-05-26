package com.example.jewerlyshop.dto.product.response;

import com.example.jewerlyshop.entity.Kind;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class ProductResponse {
    private Long id;

    private String name;

    private Double price;

    private Short quantity;

    private Long kindId;
}
