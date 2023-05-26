package com.example.jewerlyshop.mapper;

import com.example.jewerlyshop.dto.client.response.ClientResponse;
import com.example.jewerlyshop.dto.product.request.ProductUpdateRequest;
import com.example.jewerlyshop.dto.sale.request.SaleCreateRequest;
import com.example.jewerlyshop.dto.sale.request.SaleUpdateRequest;
import com.example.jewerlyshop.dto.sale.response.SaleResponse;
import com.example.jewerlyshop.entity.Product;
import com.example.jewerlyshop.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface SaleMapper {
    Sale fromDto(SaleCreateRequest dto);
    Sale fromDto(SaleUpdateRequest dto);

    @Mappings({
        @Mapping(target = "clientId", source = "entity.client.id"),
        @Mapping(target = "productId", source = "entity.product.id"),
        @Mapping(target = "employeeId", source = "entity.employee.id")
    })
    SaleResponse toDto(Sale entity);
}
