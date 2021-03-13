package com.devracoon.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class ProductOrder {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_id", columnDefinition = "VARCHAR(255)")
    private String orderId;
    
    @OneToMany(targetEntity = ProductOrderItem.class , fetch = FetchType.LAZY ,cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductOrderItem> items = new ArrayList<ProductOrderItem>();
    
    @ManyToOne(targetEntity = User.class , fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id")
    private User user;
    
    @NonNull
    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    private String address;

}