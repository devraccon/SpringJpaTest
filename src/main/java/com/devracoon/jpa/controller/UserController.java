package com.devracoon.jpa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.User;
import com.devracoon.jpa.service.SampleService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SampleService userService;
    
    @GetMapping("/findUser")
    public Optional<User> findUser(String userId) throws Exception {
        
        Optional<User> user = userService.findUserById(userId);
        
        return user;
    }
    
    @GetMapping("/getProduct")
    public String getProduct(String productId) throws Exception {
        Product product = userService.getProduct(productId);
        
        return product.getProductId();
    }

    @GetMapping("/findQueryDslTest")
    public List<ProductDto> findQueryDslTest(String productName , String itemName) throws Exception {
        List<Product> products = userService.findProductByCustom(productName , itemName);
        List<ProductDto > productDtoList = products.stream().map(ProductDto::of).collect(Collectors.toList());

        return productDtoList;
    }

    @GetMapping("/findQueryDslPasingTest")
    public List<ProductDto> findQueryDslPasingTest(String productName , String itemName , Pageable pageable) throws Exception {
//        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("productName").descending());

        List<Product> products = userService.findProductByCustom(productName , itemName , pageable);
        List<ProductDto > productDtoList = products.stream().map(ProductDto::of).collect(Collectors.toList());

        return productDtoList;
    }

    @PostMapping("/saveProduct")
    public String saveProduct(String productName) throws Exception {
        String productId = userService.saveProduct(productName);

        return productId;
    }

    
    @PutMapping("/updateProductOrphan")
    public String updateProductOrphan(String productId) throws Exception {
        userService.saveProductOrphan(productId);
        
        return "Updaet OK";
    }
    
    @PutMapping("/updateProduct")
    public String updateProduct(String productId , String productName) throws Exception {
        Product product = userService.updateProduct(productId, productName);
        
        return "Update Ok!";
    }
    
    @PutMapping("/updateProductRefresh")
    public String updateProductRefresh(String productId , String productName) throws Exception {
        Product product = userService.updateProductRefresh(productId, productName);
        
        return "Update Ok!";
    }
    
    
    @PostMapping("/saveUser")
    public String findUser(String userName , String phoneNumber) throws Exception {
        String orderId = userService.saveSampleData(userName, phoneNumber);
        
        return orderId;
    }
    
    @DeleteMapping("/deleteProduct")
    public String deleteProduct(String productId) throws Exception {
    	
        userService.deleteProduct(productId);
        
        return "Delete Ok!";
    }
    
    @DeleteMapping("/deleteOrder")
    public String deleteOrder(String orderId) throws Exception {
        userService.deleteSampleData(orderId);
        
        return "Delete Ok!";
    }
}