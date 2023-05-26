package com.example.jewerlyshop.mapper;

import com.example.jewerlyshop.dto.client.request.ClientCreateRequest;
import com.example.jewerlyshop.dto.client.request.ClientFindByNameRequest;
import com.example.jewerlyshop.dto.client.request.ClientUpdateRequest;
import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.entity.Client;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(imports = LocalDate.class)
public interface ClientMapper {
    Client fromDto(ClientCreateRequest dto);
    Client fromDto(ClientUpdateRequest dto);
    Client fromDto(ClientFindByNameRequest dto);
    ClientResponse toDto(Client entity);
}
