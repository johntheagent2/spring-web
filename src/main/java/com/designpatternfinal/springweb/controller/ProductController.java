package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    FoodService foodService;
    @GetMapping()
    public String seeFoods(Model model){
        Iterable<Food> iterable = foodService.findALlFood();
        List<Food> foods =
                StreamSupport.stream(iterable.spliterator(), false).toList();

        for (Food a: foods) {
            System.out.println(a.toString());
        }
        model.addAttribute("foods", foods);
        return "product";
    }

    @GetMapping("/add")
    public String addFood(){
        return "add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute Food food){
        foodService.addFood(food);
        return "redirect:/product";
    }


}
