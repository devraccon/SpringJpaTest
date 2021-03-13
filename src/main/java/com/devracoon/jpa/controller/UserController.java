package com.devracoon.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.User;
import com.devracoon.jpa.service.SampleService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SampleService userService;
    
    @RequestMapping("/findUser")
    public Optional<User> findUser(String userId) throws Exception {
        
        Optional<User> user = userService.findUserById(userId);
        
        return user;
    }
    
    @RequestMapping("/getProduct")
    public String getProduct(String productId) throws Exception {
        Product product = userService.getProduct(productId);
        
        return product.getProductId();
    }
    
    
    @RequestMapping("/saveProduct")
    public String saveProduct(String productName) throws Exception {
        String productId = userService.saveProduct(productName);
        
        return productId;
    }
    
    @RequestMapping("/updateProductOrphan")
    public String updateProductOrphan(String productId) throws Exception {
        userService.saveProductOrphan(productId);
        
        return "Updaet OK";
    }
    
    @RequestMapping("/updateProduct")
    public String updateProduct(String productId , String productName) throws Exception {
        Product product = userService.updateProduct(productId, productName);
        
        return "Update Ok!";
    }
    
    @RequestMapping("/updateProductRefresh")
    
    public String updateProductRefresh(String productId , String productName) throws Exception {
        Product product = userService.updateProductRefresh(productId, productName);
        
        return "Update Ok!";
    }
    
    
    @RequestMapping("/saveUser")
    public String findUser(String userName , String phoneNumber) throws Exception {
        String orderId = userService.saveSampleData(userName, phoneNumber);
        
        return orderId;
    }
    
    @RequestMapping("/deleteProduct")
    public String deleteProduct(String productId) throws Exception {
    	
        userService.deleteProduct(productId);
        
        return "Delete Ok!";
    }
    
    @RequestMapping("/deleteOrder")
    public String deleteOrder(String orderId) throws Exception {
        userService.deleteSampleData(orderId);
        
        return "Delete Ok!";
    }
}