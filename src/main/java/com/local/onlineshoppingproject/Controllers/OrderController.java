package com.local.onlineshoppingproject.Controllers;

import com.local.onlineshoppingproject.DTOs.OrderDTO;
import com.local.onlineshoppingproject.Entities.Order;
import com.local.onlineshoppingproject.Mappers.OrderMapper;
import com.local.onlineshoppingproject.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable Integer customerId) {

        List<Order> orders = orderService.getOrdersByCustomerId(customerId);

        List<OrderDTO> orderDTOs = orders.stream()
                .map(OrderMapper.INSTANCE::orderToOrderDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(orderDTOs);
    }

    @PostMapping("/{customerId}")
    public Order addOrder(@PathVariable Integer customerId) {

        return orderService.addNewOrder(customerId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        if (orderService.getOrderById(id).isPresent()) {
            order.setId(id);
            Order updatedOrder = orderService.saveOrder(order);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        if (orderService.getOrderById(id).isPresent()) {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}