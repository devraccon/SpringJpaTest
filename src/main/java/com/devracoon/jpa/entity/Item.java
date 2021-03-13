package com.devracoon.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "item_id", columnDefinition = "VARCHAR(255)")
    private String itemId;
    
    @ManyToOne(targetEntity = Product.class ,fetch = FetchType.LAZY )
    @JoinColumn(name = "product_id")
    private Product product;
    
    @NonNull
    @Column(name = "item_name", columnDefinition = "VARCHAR(255)")
    private String itemName;
    
    @Column(name = "item_number", columnDefinition = "VARCHAR(255)")
    private String itemNumber;
}