package com.local.onlineshoppingproject.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;
    private Integer categoryId;
}
