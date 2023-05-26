package com.example.jewerlyshop.dto.client.request;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class ClientUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthDate;
}
