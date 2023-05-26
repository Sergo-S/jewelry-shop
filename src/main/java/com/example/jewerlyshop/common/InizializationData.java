package com.example.jewerlyshop.common;

import com.example.jewerlyshop.repository.ClientRepository;
import com.example.jewerlyshop.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InizializationData {
        //implements CommandLineRunner
    private final ClientRepository clientRepository;

}
