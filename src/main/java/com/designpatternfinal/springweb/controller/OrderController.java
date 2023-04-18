package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class OrderController {
    @Autowired
    FoodService foodService;
    @GetMapping("/order")
    public String allFood(Model model){
        Iterable<Food> iterable = foodService.findALlFood();
        List<Food> foods =
                StreamSupport.stream(iterable.spliterator(), false).toList();

        for (Food a: foods) {
            System.out.println(a.toString());
        }
        model.addAttribute("foods", foods);
        return "order";
    }
}
