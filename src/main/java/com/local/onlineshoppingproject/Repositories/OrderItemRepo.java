package com.local.onlineshoppingproject.Repositories;

import com.local.onlineshoppingproject.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

    OrderItem getOrderItemByOrderId(int id);

    @Query("SELECT o FROM OrderItem o WHERE o.order.id = :orderId")
    List<OrderItem> getOrderItemsByOrderId(@Param("orderId") int id);
}
