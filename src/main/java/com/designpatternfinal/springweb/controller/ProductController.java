package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.AccountService;
import com.designpatternfinal.springweb.Service.OrderService;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.order.Order;
import com.designpatternfinal.springweb.model.repository.FoodRepository;
import com.designpatternfinal.springweb.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/add")
public class ProductController {
    @Autowired
    FoodRepository foodRepository;
    @GetMapping
    public String addFood(){
        return "add";
    }

    @PostMapping
    public String addFood(@ModelAttribute Food food){
        System.out.println(food.toString());
        foodRepository.save(food);
        return "add";
    }


}
