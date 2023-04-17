package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.order.Order;
import com.designpatternfinal.springweb.model.repository.FoodRepository;
import com.designpatternfinal.springweb.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;

    public OrderService() {
    }

    public void addFood(Food food){
        foodRepository.save(food);
    }

    public List<Food> findALlFood(){
        return (List<Food>) foodRepository.findAll();
    }

    public List<Order> findOrder(String username){
        return orderRepository.findOrderByUsername(username);
    }
}
