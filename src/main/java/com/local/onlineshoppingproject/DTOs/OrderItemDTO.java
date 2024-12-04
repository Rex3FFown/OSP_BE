package com.local.onlineshoppingproject.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.local.onlineshoppingproject.Entities.Order;
import com.local.onlineshoppingproject.Entities.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private Integer id;

    private BigDecimal price;

    private Integer count;

    private Product product;

}
