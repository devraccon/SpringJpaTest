package com.devracoon.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devracoon.jpa.entity.Item;
import com.devracoon.jpa.entity.Product;
import com.devracoon.jpa.entity.ProductOrder;
import com.devracoon.jpa.entity.ProductOrderItem;
import com.devracoon.jpa.entity.User;
import com.devracoon.jpa.repository.ProductOrderRepository;
import com.devracoon.jpa.repository.ProductRepository;
import com.devracoon.jpa.repository.UserRepository;

@Service
public class SampleServiceImpl implements SampleService{

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private ProductOrderRepository productOrderRepo;
    
    public Optional<User> findUserById(String userId) throws Exception {
        return userRepo.findById(userId);
    }
    
    public Product getProduct(String productId) throws Exception {
        Optional<Product> product = productRepo.findById(productId);
        System.out.println(product.get().getItems().size());
        return product.get();
    }
    
    @Transactional
    public String saveProduct(String productName ) throws Exception {
        Product product = new Product(productName);
        for(int i = 0 ; i < 2 ; i++) {
            Item item = new Item("Product Item " + i);
            item.setItemNumber("Product Item "+ i +" Number");
            item.setProduct(product);
            product.getItems().add(item);
        }
        productRepo.save(product);
        return product.getProductId();
    }
    
    @Transactional
    public Product updateProduct(String productId , String productName ) throws Exception {
        Product product = productRepo.findById(productId).get();
        product.setProductName(productName);
        if(product.getItems().size() > 0 ) {
            for(int i = 0 ; i < product.getItems().size() ; i++) {
                Item item = product.getItems().get(i);
                item.setItemName(productName + " Item Change" + i);
            }
            Item additem = new Item("Product Item ADD ");
            additem.setItemNumber("Product Item ADD Number");
            additem.setProduct(product);
            product.getItems().add(additem);
            
        }else {
            for(int i = 0 ; i < 2 ; i++) {
                Item item = new Item("Product Item " + i);
                item.setItemNumber("Product Item "+ i +" Number");
                item.setProduct(product);
                product.getItems().add(item);
            }
        }
        productRepo.save(product);
        
        return product;
    }
    
    
    @Transactional
    public String saveSampleData(String userName , String phoneNumber ) throws Exception {
        //Sample User Data 
        User user = new User(userName , phoneNumber);
        userRepo.save(user);
        
        //Sample Product Data
        List<Product> products = new ArrayList<Product>();
        for(int i = 0 ; i < 2 ; i++) {
            Product product = new Product("Product "+ i);
            
            for(int j = 0 ; j < 2 ; j++) {
                Item item = new Item("Product "+i+" Item " + j);
                item.setItemNumber("Product "+i+" Item "+ j +" Number");
                item.setProduct(product);
                product.getItems().add(item);
            }
            
            products.add(product);
        }
        productRepo.saveAll(products);
        
        // Sample Order Data
        ProductOrder order = new ProductOrder();
        order.setUser(user);
        order.setAddress("address 1-1");
        
        for(Product p : products) {
            ProductOrderItem item = new ProductOrderItem();
            item.setProduct(p);
            item.setProductOrder(order);
            order.getItems().add(item);
        }
        productOrderRepo.save(order);
        
        return order.getOrderId();
               
        
    }
    
    @Transactional
    public void deleteProduct(String productId) throws Exception {
        productRepo.deleteById(productId);
    }
    
    @Transactional
    public void deleteSampleData(String orderId) throws Exception {
        ProductOrder order = productOrderRepo.findById(orderId).get();
        productOrderRepo.delete(order);
        
    }
        
       
}