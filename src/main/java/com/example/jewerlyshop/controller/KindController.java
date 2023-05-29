package com.example.jewerlyshop.controller;


import com.example.jewerlyshop.dto.client.request.ClientUpdateRequest;
import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.dto.kind.request.KindCreateRequest;
import com.example.jewerlyshop.dto.kind.request.KindUpdateRequest;
import com.example.jewerlyshop.dto.kind.response.KindResponse;
import com.example.jewerlyshop.entity.Kind;
import com.example.jewerlyshop.mapper.KindMapper;
import com.example.jewerlyshop.service.KindService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/kind")
public class KindController {
    private final KindService kindService;
    private final KindMapper kindMapper;

    @GetMapping("/getAll")
    public List<KindResponse> getAllKinds(){
        return kindService.getAllKinds().stream().map(kindMapper::toDto).toList();
    }

    @GetMapping("/id/{id}")
    public KindResponse getById(@PathVariable Long id){
        return kindMapper.toDto(kindService.getKindById(id));
    }

    @PostMapping("/create")
    public KindResponse create(@Valid @RequestBody KindCreateRequest kindDto) {
        return kindMapper.toDto(kindService.create(kindMapper.fromDto(kindDto)));
    }

    @PutMapping("/update/{id}")
    public KindResponse update(@Valid @RequestBody KindUpdateRequest kindDto,@PathVariable Long id){
        return kindMapper.toDto((kindService.update(kindMapper.fromDto(kindDto),id)));
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        kindService.deleteById(id);
    }
}
