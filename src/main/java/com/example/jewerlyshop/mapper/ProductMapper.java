package com.example.jewerlyshop.mapper;

import com.example.jewerlyshop.dto.kind.request.KindUpdateRequest;
import com.example.jewerlyshop.dto.product.request.ProductCreateRequest;
import com.example.jewerlyshop.dto.product.request.ProductUpdateRequest;
import com.example.jewerlyshop.dto.product.response.ProductResponse;
import com.example.jewerlyshop.entity.Kind;
import com.example.jewerlyshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {
    Product fromDto(ProductCreateRequest dto);
    Product fromDto(ProductUpdateRequest dto);

    @Mapping(target = "kindId", source = "entity.kind.id")
    ProductResponse toDto(Product entity);
}
