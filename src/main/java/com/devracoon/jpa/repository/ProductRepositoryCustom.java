package com.devracoon.jpa.repository;

import com.devracoon.jpa.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepositoryCustom {
    public List<Product> findProductByCustom(String productName , String itemName);

    List<Product> findProductByCustomPasing(String productName , String itemName , Pageable pageable);
}
