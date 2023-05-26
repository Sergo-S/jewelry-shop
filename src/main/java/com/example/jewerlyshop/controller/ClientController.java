package com.example.jewerlyshop.controller;

import com.example.jewerlyshop.dto.client.request.ClientCreateRequest;
import com.example.jewerlyshop.dto.client.request.ClientFindByNameRequest;
import com.example.jewerlyshop.dto.client.request.ClientUpdateRequest;
import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.mapper.ClientMapper;
import com.example.jewerlyshop.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping("/getAll")
    public List<ClientResponse> getAllClients(){
        return clientService.getAllClients().stream().map(clientMapper::toDto).toList();
    }

    @GetMapping("/id/{id}")
    public ClientResponse getById(@PathVariable Long id){
        return clientMapper.toDto(clientService.getClientById(id));
    }

    @GetMapping("/name")
    public ClientResponse getByName(@RequestBody ClientFindByNameRequest clientDto){
        return clientMapper.toDto(clientService.getClientByName(clientMapper.fromDto(clientDto)));
    }

    @PostMapping("/create")
    public ClientResponse create(@RequestBody ClientCreateRequest clientDto) {
        return clientMapper.toDto(clientService.create(clientMapper.fromDto(clientDto)));
    }

    @PutMapping("/update/{id}")
    public ClientResponse update(@RequestBody ClientUpdateRequest clientDto, @PathVariable Long id){
        return clientMapper.toDto((clientService.update(clientMapper.fromDto(clientDto),id)));
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
