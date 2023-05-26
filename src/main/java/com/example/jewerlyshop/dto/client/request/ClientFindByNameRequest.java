package com.example.jewerlyshop.dto.client.request;

import com.sun.istack.NotNull;
import lombok.Data;
@Data
public class ClientFindByNameRequest {

        @NotNull
        private String name;
}
