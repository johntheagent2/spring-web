package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;
import com.designpatternfinal.springweb.model.PickupPayment;
import com.designpatternfinal.springweb.model.ShippingPayment;
import com.designpatternfinal.springweb.repository.PickupPaymentRepository;
import com.designpatternfinal.springweb.repository.ShippingPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PickupPaymentService implements PaymentStrategy{
    @Autowired
    PickupPaymentRepository pickupPaymentRepository;
    @Autowired
    OrderService orderService;
    public void saveOrUpdate(PickupPayment pickupPayment){
        pickupPaymentRepository.save(pickupPayment);
    }

    @Override
    public void pay(Order order) {
        PickupPayment pickupPayment = new PickupPayment();
        pickupPayment.setOrder(order);
        orderService.saveOrUpdate(order);
        saveOrUpdate(pickupPayment);
    }

    public Iterable<PickupPayment> getAll(){
        return pickupPaymentRepository.findAll();
    }
}
