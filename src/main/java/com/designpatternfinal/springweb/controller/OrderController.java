package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.AccountService;
import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.Service.OrderService;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class OrderController {
    @Autowired
    FoodService foodService;
    @Autowired
    OrderService orderService;
    @Autowired
    AccountService accountService;
    @GetMapping("/order")
    public String allFood(Model model){
        List<Order> orderList = orderService.findOrder(accountService.getCurrentAccount().getUsername());
        List<Order> ordersToPrint = new ArrayList<>();

        model.addAttribute("orderList", ordersToPrint);
        return "order";
    }
}
