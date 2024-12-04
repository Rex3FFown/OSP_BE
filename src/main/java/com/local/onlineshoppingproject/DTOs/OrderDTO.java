package com.local.onlineshoppingproject.DTOs;

import com.local.onlineshoppingproject.Entities.Customer;
import com.local.onlineshoppingproject.Entities.OrderItem;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private Integer id;

    private LocalDateTime date;

    private Customer customer;

    private List<OrderItemDTO> orderItems;
}
