package com.websystique.spring.service;
 
import com.websystique.springsecurity.model.ProductOrder;
 
public interface OrderService {
 
    public void sendOrderConfirmation(ProductOrder productOrder);
     
}