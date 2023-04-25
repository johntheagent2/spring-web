package com.designpatternfinal.springweb.repository;

import com.designpatternfinal.springweb.model.PickupPayment;
import com.designpatternfinal.springweb.model.ShippingPayment;
import org.springframework.data.repository.CrudRepository;

public interface PickupPaymentRepository extends CrudRepository<PickupPayment, Integer> {
}
