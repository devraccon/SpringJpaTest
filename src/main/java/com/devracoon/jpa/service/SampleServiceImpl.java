package com.devracoon.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.devracoon.jpa.entity.*;
import com.devracoon.jpa.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devracoon.jpa.repository.ProductOrderRepository;
import com.devracoon.jpa.repository.ProductRepository;
import com.devracoon.jpa.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService{

    private final UserRepository userRepo;
    
    private final ProductRepository productRepo;
    
    private final ProductOrderRepository productOrderRepo;

    private final ContentRepository contentRepository;

    @PersistenceContext
    private EntityManager entityManager;
    
    public Optional<User> findUserById(String userId) throws Exception {
        return userRepo.findById(userId);
    }
    
    public Product getProduct(String productId) throws Exception {
        Optional<Product> product = productRepo.findById(productId);
        System.out.println(product.get().getItems().size());
        return product.get();
    }

    public List<Product> findProductByCustom(String productName , String itemName) throws Exception{
        return productRepo.findProductByCustom(productName , itemName);
    }

    public List<Product> findProductByCustom(String productName , String itemName , Pageable pageable )throws Exception{
        return productRepo.findProductByCustomPasing(productName , itemName , pageable);
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
    public Product updateProductRefresh(String productId , String productName ) throws Exception {
        Product product = productRepo.findById(productId).get();
        product.setProductName(productName);
        String changeItemName = productName + " Item Change";
        if(product.getItems().size() > 0 ) {
            for(int i = 0 ; i < product.getItems().size() ; i++) {
                Item item = product.getItems().get(i);
                item.setItemName(changeItemName + i);
            }
//            엔티티를 Refresh할경우 Entity가 새로 생성된 경우 ID가 없어서 Refresh할때 Null Identifier 라는 에러 발생함.
//            Item additem = new Item("Product Item ADD ");
//            additem.setItemNumber("Product Item ADD Number");
//            additem.setProduct(product);
//            product.getItems().add(additem);
            
        }else {
            for(int i = 0 ; i < 2 ; i++) {
                Item item = new Item("Product Item " + i);
                item.setItemNumber("Product Item "+ i +" Number");
                item.setProduct(product);
                product.getItems().add(item);
            }
        }
        entityManager.refresh(product);
        
        log.info("Change Product Name : " + productName + " Current Producct Name : " + product.getProductName());
        log.info("Change Item Name : " +  changeItemName + " Current Item Name : " + product.getItems().get(0).getItemName());
        
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
    	Product product = productRepo.findById(productId).get();
        productRepo.delete(product);
    }
    
    @Transactional
    public void saveProductOrphan(String productId) throws Exception {
    	Product product = productRepo.findById(productId).get();
    	product.getItems().remove(0);
    	
        productRepo.save(product);
    }
    
    @Transactional
    public void deleteSampleData(String orderId) throws Exception {
        ProductOrder order = productOrderRepo.findById(orderId).get();
        productOrderRepo.delete(order);
        
    }

    public List<Contents> findContents(){
        return contentRepository.findContentsByCustom();
    }

    public List<Contents> findContentsFunctionTest(){
        return contentRepository.findContentsFunctionTest();
    }
        
       
}