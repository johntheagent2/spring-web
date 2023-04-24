package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Account;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.Order;
import com.designpatternfinal.springweb.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IService{
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public void saveOrUpdate(Object o) {
        orderRepository.save((Order) o);
    }

    public Iterable<Order> getAllOrder(){
        return orderRepository.findAll();
    }
    public List<Order> findOrderOfAccount(String username){
        return orderRepository.findOrderByUsername(username);
    }
    public Order findOrderByOrderID(int oid){
        return orderRepository.findOrderByOid(oid);
    }
}
