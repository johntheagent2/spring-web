package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.model.Cart;
import com.designpatternfinal.springweb.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    FoodService foodService;

    Cart cart = new Cart();

    @GetMapping
    public String seeMenu(Model model){
        Iterable<Food> iterable = foodService.findALlFood();
        List<Food> foods =
                StreamSupport.stream(iterable.spliterator(), false).toList();
        model.addAttribute("foods", foods);
        return "menu";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam int id){
        cart.addToCart(foodService.findFood(id));
        System.out.println(cart.getFoodsInCart());
        return "redirect:/menu";
    }
}
