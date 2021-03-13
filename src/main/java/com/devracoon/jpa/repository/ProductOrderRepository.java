package com.devracoon.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devracoon.jpa.entity.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, String> {

}