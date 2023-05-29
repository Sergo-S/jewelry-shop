package com.example.jewerlyshop.service;

import com.example.jewerlyshop.common.exceptions.BadRequestException;
import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.repository.ClientRepository;
import com.example.jewerlyshop.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor

public class ClientService {
    private final ClientRepository clientRepository;
    private final SaleRepository saleRepository;

    public Client create (Client client){
        client.setRegistrationDate(LocalDate.now());
        return clientRepository.save(client);
    }

    public Client update (Client client,Long id){

        Client clientOld = getClientById(id);

        clientOld.setName(client.getName());
        clientOld.setBirthDate(client.getBirthDate());

        return clientRepository.save(clientOld);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("The client not found by Id " + id));
    }

    public Client getClientByName(Client client) {
        return clientRepository.findByName(client.getName())
                .orElseThrow(() -> new BadRequestException("The client not found by name " + client.getName()));
    }

    public void deleteById(Long id) {
        saleRepository.findByClientId(id).ifPresent(s -> {
            s.setClient(null);
            saleRepository.save(s);
        });

        clientRepository.deleteById(id);
    }
}
