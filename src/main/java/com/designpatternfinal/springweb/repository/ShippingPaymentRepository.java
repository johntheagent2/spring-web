package com.designpatternfinal.springweb.repository;

import com.designpatternfinal.springweb.model.ShippingPayment;
import org.springframework.data.repository.CrudRepository;

public interface ShippingPaymentRepository extends CrudRepository<ShippingPayment, Integer> {
}
