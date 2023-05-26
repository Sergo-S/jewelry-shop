package com.example.jewerlyshop.service;


import com.example.jewerlyshop.dto.product.response.ProductResponse;
import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.entity.Kind;
import com.example.jewerlyshop.entity.Product;
import com.example.jewerlyshop.repository.KindRepository;
import com.example.jewerlyshop.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KindService {
    private final KindRepository kindRepository;
    private final ProductRepository productRepository;

    public Kind create (Kind kind){
        return kindRepository.save(kind);
    }

    public Kind update (Kind kind,Long id){

        Kind kindOld = getKindById(id);

        kindOld.setMetal(kind.getMetal());
        kindOld.setCategory(kind.getCategory());
        kindOld.setFineness(kind.getFineness());
        kindOld.setGem(kind.getGem());
        return kindRepository.save(kindOld);
    }
    public List<Kind> getAllKinds(){
        return kindRepository.findAll();
    }

    public Kind getKindById(Long id) {
        return kindRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The kind not found by Id " + id));
    }

    public void deleteById(Long id) {

        productRepository.findByKindId(id).ifPresent(p -> {
            p.setKind(null);
            productRepository.save(p);
        });
        kindRepository.deleteById(id);
    }
}
