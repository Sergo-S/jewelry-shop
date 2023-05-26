package com.example.jewerlyshop.mapper;


import com.example.jewerlyshop.dto.client.request.ClientUpdateRequest;
import com.example.jewerlyshop.dto.kind.request.KindCreateRequest;
import com.example.jewerlyshop.dto.kind.request.KindUpdateRequest;
import com.example.jewerlyshop.dto.kind.response.KindResponse;
import com.example.jewerlyshop.entity.Client;
import com.example.jewerlyshop.entity.Kind;
import org.mapstruct.Mapper;

@Mapper
public interface KindMapper {
    Kind fromDto(KindCreateRequest dto);
    Kind fromDto(KindUpdateRequest dto);
    KindResponse toDto(Kind entity);
}
