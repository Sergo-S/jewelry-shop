package com.example.jewerlyshop.dto.client.request;

import com.sun.istack.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthDate;
}
