package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Order;
import com.designpatternfinal.springweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService extends IService<Order>{
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public void saveOrUpdate(Order order) {
        orderRepository.save(order);
    }

    public Iterable<Order> getAll(){
        return orderRepository.findAll();
    }
    public List<Order> findOrderOfAccount(String username){
        return orderRepository.findOrderByUsername(username);
    }
    public Order findOrderByOrderID(int oid){
        return orderRepository.findOrderByOid(oid);
    }
}
