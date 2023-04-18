package com.designpatternfinal.springweb.model.repository;

import com.designpatternfinal.springweb.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findOrderByUsername(String username);
}
