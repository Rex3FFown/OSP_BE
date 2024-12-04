package com.local.onlineshoppingproject.Mappers;

import com.local.onlineshoppingproject.DTOs.OrderDTO;
import com.local.onlineshoppingproject.Entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
  //  @Mapping(target = "id",ignore = true)
  @Mapping(source = "id", target = "id")
    OrderDTO orderToOrderDTO(Order order);
}
