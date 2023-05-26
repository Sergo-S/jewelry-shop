package com.example.jewerlyshop.dto.kind.response;

import com.example.jewerlyshop.common.enums.Metal;
import lombok.Data;

@Data
public class KindResponse {
    private Long id;

    private Metal metal;

    private String category;

    private Short fineness;

    private Boolean gem;

}
