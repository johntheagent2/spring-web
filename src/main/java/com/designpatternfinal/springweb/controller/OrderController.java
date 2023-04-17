package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.OrderService;
import com.designpatternfinal.springweb.model.order.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{username}")
    public List<Order> findOrder(@PathVariable String username){
        OrderService orderService = new OrderService();
        return orderService.findOrder(username);
    }
}
