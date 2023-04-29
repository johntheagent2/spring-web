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
        Iterable<Food> iterable = foodService.getAll();
        List<Food> foods =
                StreamSupport.stream(iterable.spliterator(), false).toList();
        model.addAttribute("foods", foods);
        return "product";
    }

    @GetMapping("/add")
    public String addFood(){
        return "add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute Food food){
        foodService.saveOrUpdate(food);
        return "redirect:/product";
    }

    @GetMapping("/remove")
    public String removeFood(@RequestParam int id){
        foodService.deleteFood(id);
        return "redirect:/product";
    }


    @GetMapping("/edit")
    public String editFood(@RequestParam int id, Model model){
        Food food = foodService.findFood(id);
        model.addAttribute("food", food);
        return "edit";
    }

    @PostMapping("/edit")
    public String editFood(@ModelAttribute Food food){
        foodService.saveOrUpdate(food);
        return "redirect:/product";
    }
}
