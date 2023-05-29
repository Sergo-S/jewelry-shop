package com.example.jewerlyshop.service;


import com.example.jewerlyshop.common.exceptions.BadRequestException;
import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.entity.Kind;
import com.example.jewerlyshop.entity.Product;
import com.example.jewerlyshop.entity.Sale;
import com.example.jewerlyshop.repository.KindRepository;
import com.example.jewerlyshop.repository.ProductRepository;
import com.example.jewerlyshop.repository.SaleRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    private final KindService kindService;

    public Product create (Product product, Long kindId){

        product.setKind(kindService.getKindById(kindId));
        return productRepository.save(product);
    }

    public Product update (Product product,Long id){

        Product productOld = getProductById(id);

        productOld.setName(product.getName());
        productOld.setPrice(product.getPrice());
        productOld.setQuantity(product.getQuantity());
        return productRepository.save(productOld);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getByKindId(Long kindId){
        return productRepository.findByKindId(kindId);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("The product not found by Id " + id));
    }

    public void deleteById(Long id) {
        saleRepository.findByProductId(id).ifPresent(s -> {
            s.setProduct(null);
            saleRepository.save(s);
        });

        productRepository.deleteById(id);
    }
}
