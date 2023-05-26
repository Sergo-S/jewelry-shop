package com.example.jewerlyshop.dto.kind.request;

import com.example.jewerlyshop.common.enums.Metal;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class KindCreateRequest {
    @NotNull
    private Metal metal;

    @NotNull
    private String category;

    @NotNull
    private Short fineness;

    @NotNull
    private Boolean gem;
}
