package com.devracoon.jpa.service;

import java.util.List;
import java.util.Optional;

import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.User;
import org.springframework.data.domain.Pageable;

public interface SampleService {
    
    public Optional<User> findUserById(String userId) throws Exception;
    
    public Product getProduct(String productId) throws Exception;

    public List<Product> findProductByCustom(String productName , String itemName) throws Exception;

    public List<Product> findProductByCustom(String productName , String itemName , Pageable pageable) throws Exception;
    
    public String saveProduct(String productName ) throws Exception;
    
    public void saveProductOrphan(String productId) throws Exception;
    
    public Product updateProduct(String productId , String productName ) throws Exception;
    
    public Product updateProductRefresh(String productId , String productName ) throws Exception;
    
    public String saveSampleData(String userName , String phoneNumber) throws Exception;
    
    public void deleteProduct(String productId) throws Exception;
    
    public void deleteSampleData(String orderId) throws Exception;
}