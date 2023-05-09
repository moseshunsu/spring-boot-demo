package com.higherAchievers.springbootdemo.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private Integer quantity;
    private String description;
    private String skuCode;
}
