package com.local.onlineshoppingproject.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductOrderDTO {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String imageUrl;
}
