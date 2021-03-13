package com.devracoon.jpa.service;

import java.util.Optional;

import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.User;

public interface SampleService {
    
    public Optional<User> findUserById(String userId) throws Exception;
    
    public Product getProduct(String productId) throws Exception;
    
    public String saveProduct(String productName ) throws Exception;
    
    public Product updateProduct(String productId , String productName ) throws Exception;
    
    public String saveSampleData(String userName , String phoneNumber) throws Exception;
    
    public void deleteProduct(String productId) throws Exception;
    
    public void deleteSampleData(String orderId) throws Exception;
}