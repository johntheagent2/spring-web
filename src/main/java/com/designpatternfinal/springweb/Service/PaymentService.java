package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentService {
    @Autowired
    private PaymentFactory factory;
    public void processOrder(Order order, String paymentMethod){
        PaymentStrategy paymentService = factory.getInstance(paymentMethod);
        paymentService.pay(order);
        System.out.println(order.getPrice());
    }
}
