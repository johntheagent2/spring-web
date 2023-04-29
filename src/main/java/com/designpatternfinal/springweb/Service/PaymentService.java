package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentService {
    @Autowired
    private PaymentFactory factory;
    PaymentStrategy paymentService;
    public void processOrder(Order order, String paymentMethod){
        paymentService = factory.getInstance(paymentMethod);
        paymentService.pay(order);
        System.out.println(order.getPrice());
    }
}
