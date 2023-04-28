package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;
import com.designpatternfinal.springweb.model.ShippingPayment;
import com.designpatternfinal.springweb.repository.ShippingPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ShippingPaymentService implements PaymentStrategy{
    @Autowired
    ShippingPaymentRepository shippingPaymentRepository;
    @Autowired
    OrderService orderService;

    public void saveOrUpdate(ShippingPayment shippingPayment){
        shippingPaymentRepository.save(shippingPayment);
    }

    @Override
    public void pay(Order order) {
        ShippingPayment shippingPayment = new ShippingPayment();
        order.setPrice(order.getPrice() + 25000);
        shippingPayment.setOrder(order);
        orderService.saveOrUpdate(order);
        saveOrUpdate(shippingPayment);
    }

    public Iterable<ShippingPayment> getAll(){
        return shippingPaymentRepository.findAll();
    }
}
