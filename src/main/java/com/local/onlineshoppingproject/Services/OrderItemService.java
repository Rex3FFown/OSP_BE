package com.local.onlineshoppingproject.Services;

import com.local.onlineshoppingproject.Entities.*;
import com.local.onlineshoppingproject.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepository;
    @Autowired
    private BasketItemRepo basketItemRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private BasketRepo basketRepo;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Integer id) {
        return orderItemRepository.findById(id);
    }
    public int getOrderItemCountById(Integer id) {
        OrderItem orderItem = orderItemRepository.getOrderItemByOrderId(id);
        int count = orderItem.getCount();
        return count;
    }

    public List<OrderItem> getOrderItemsByOrderId(Integer id) {
        List<OrderItem> orderItem = orderItemRepository.getOrderItemsByOrderId(id);
        return orderItem;
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }



    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }


}