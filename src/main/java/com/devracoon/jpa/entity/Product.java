package com.devracoon.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "product_id", columnDefinition = "VARCHAR(255)")
    private String productId;
    
    @NonNull
    @Column(name = "product_name", columnDefinition = "VARCHAR(255)")
    private String productName;
    
    @OneToMany(mappedBy = "product" , targetEntity = Item.class , fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    private List<Item> items = new ArrayList<Item>();
    
}