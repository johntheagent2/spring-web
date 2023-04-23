package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.OrderService;

import com.designpatternfinal.springweb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderService orderService;


    @GetMapping
    public String seeAdminPage(Model model){
        Iterable<Order> iterable = orderService.getAllOrder();
        List<Order> orderList =
                StreamSupport.stream(iterable.spliterator(), false).toList();
        model.addAttribute("orderList", orderList);
        return "admin";
    }
}
