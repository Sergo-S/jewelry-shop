package com.example.jewerlyshop.controller;

import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.dto.kind.request.KindCreateRequest;
import com.example.jewerlyshop.dto.kind.request.KindUpdateRequest;
import com.example.jewerlyshop.dto.kind.response.KindResponse;
import com.example.jewerlyshop.dto.product.request.ProductCreateRequest;
import com.example.jewerlyshop.dto.product.request.ProductUpdateRequest;
import com.example.jewerlyshop.dto.product.response.ProductResponse;
import com.example.jewerlyshop.entity.Kind;
import com.example.jewerlyshop.entity.Product;
import com.example.jewerlyshop.mapper.ProductMapper;
import com.example.jewerlyshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/getAll")
    public List<ProductResponse> getAllClients(){
        return productService.getAllProducts().stream().map(productMapper::toDto).toList();

    }

    @GetMapping("/id/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productMapper.toDto(productService.getProductById(id));
    }

    @PostMapping("/create")
    public ProductResponse create(@Valid @RequestBody ProductCreateRequest productDto) {
        return productMapper.toDto(productService.create(productMapper.fromDto(productDto),productDto.getKindId()));
    }

    @PutMapping("/update/{id}")
    public ProductResponse update(@Valid @RequestBody ProductUpdateRequest productDto,@PathVariable Long id){
        return productMapper.toDto((productService.update(productMapper.fromDto(productDto),id)));
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
