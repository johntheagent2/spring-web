package com.designpatternfinal.springweb.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
    @Bean(name="shippingPayment")
    public PaymentStrategy shippingPayment(){
        return new ShippingPaymentService();
    }

    @Bean(name="pickupPayment")
    public PaymentStrategy pickupPayment(){
        return new PickupPaymentService();
    }
}
