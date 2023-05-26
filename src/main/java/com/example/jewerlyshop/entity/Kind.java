package com.example.jewerlyshop.entity;

import com.example.jewerlyshop.common.enums.Metal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kind")
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Metal metal;

    private String category;

    private Short fineness;

    private Boolean gem;

}
