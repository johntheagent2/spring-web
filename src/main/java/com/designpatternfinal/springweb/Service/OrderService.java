package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Account;
import com.designpatternfinal.springweb.model.Order;
import com.designpatternfinal.springweb.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService{
    @Autowired
    public OrderRepository orderRepository;

    public void saveOrUpdate(Order order){

    }

    public List<Order> findOrder(String username){
        return orderRepository.findOrderByUsername(username);
    }
}
