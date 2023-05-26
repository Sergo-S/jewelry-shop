package com.example.jewerlyshop.dto.client.response;

import com.example.jewerlyshop.dto.sale.response.SaleResponse;
import com.example.jewerlyshop.entity.Sale;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Set;

@Data
public class ClientResponse {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate registrationDate;
}
