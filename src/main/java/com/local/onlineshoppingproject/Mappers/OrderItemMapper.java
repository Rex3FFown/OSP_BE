package com.local.onlineshoppingproject.Mappers;

import com.local.onlineshoppingproject.DTOs.OrderItemDTO;
import com.local.onlineshoppingproject.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
    @Mapping(source="id",target ="id")
    OrderItemDTO entityToDto(OrderItem orderItem);

}
