package com.devracoon.jpa.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
    private String itemId;
    private String itemName;
}
