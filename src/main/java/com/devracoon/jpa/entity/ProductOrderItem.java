package com.devracoon.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class ProductOrderItem {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_item_id", columnDefinition = "VARCHAR(255)")
    private String orderItemId;
    
    @NonNull
    @ManyToOne(targetEntity = ProductOrder.class , fetch = FetchType.LAZY)
    private ProductOrder productOrder;
    
    @NonNull
    @ManyToOne(targetEntity = Product.class , fetch = FetchType.LAZY)
    private Product product;
    
    
    
}