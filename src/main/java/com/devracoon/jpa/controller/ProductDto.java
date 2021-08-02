package com.devracoon.jpa.controller;

import com.devracoon.jpa.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProductDto {
    private String productId;
    private String productName;

    private List<ItemDto> itemDtoList;

    public static ProductDto of(Product product){
        ProductDto productDto = ProductDto.builder().productId(product.getProductId())
                .productName(product.getProductName()).build();
        List<ItemDto> items = new ArrayList<>();
        product.getItems().stream().forEach(i ->{
            items.add(ItemDto.builder().itemId(i.getItemId()).itemName(i.getItemName()).build());
        });
        productDto.itemDtoList = items;

        return productDto;


    }
}
