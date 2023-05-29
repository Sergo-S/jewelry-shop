package com.example.jewerlyshop.dto.client.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
@Data
public class ClientFindByNameRequest {

        @NotBlank(message = "The name is required.")
        private String name;
}
