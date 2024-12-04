package com.local.onlineshoppingproject.Mappers;

import com.local.onlineshoppingproject.DTOs.ProductOrderDTO;
import com.local.onlineshoppingproject.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

//    @Mapping(source = "categoryId", target = "category.id")
//    Product toEntity(ProductUpdateDTO productDTO);
//
//    @Mapping(source = "category.id", target = "categoryId")
//    ProductUpdateDTO toDTO(Product product);

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source="id", target="id")
    ProductOrderDTO productToProductOrderDTO(Product product);

}