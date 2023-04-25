package com.designpatternfinal.springweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
    @Autowired
    @Qualifier("shippingPayment")
    private PaymentStrategy shippingPayment;
    @Autowired
    @Qualifier("pickupPayment")
    private PaymentStrategy pickupPayment;

    public PaymentStrategy getInstance(String paymentMethod){
        if(paymentMethod.equals("shipping")){
            return shippingPayment;
        }else{
            return pickupPayment;
        }
    }
}
