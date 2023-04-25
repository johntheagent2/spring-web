package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface PaymentStrategy {
    public void pay(Order order);
}
