package com.example.jewerlyshop.dto.kind.request;

import com.example.jewerlyshop.common.enums.Metal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.jewerlyshop.common.validation.ShortLength;
import lombok.Data;

@Data
public class KindCreateRequest {
    @NotNull(message = "The metal is required.")
    private Metal metal;

    @NotBlank(message = "The category is required.")
    private String category;

    @NotNull(message = "The fineness is required.")
    @ShortLength(value = 3,message = "The length of fineness must be 3.")
    private Short fineness;

    @NotNull(message = "The gem is required.")
    private Boolean gem;
}
