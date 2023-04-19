package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.AccountService;
import com.designpatternfinal.springweb.Service.CartService;
import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.dao.CartRequest;
import com.designpatternfinal.springweb.model.Cart;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    FoodService foodService;

    @Autowired
    AccountService accountService;

    @Autowired
    CartService cartService;

    @GetMapping
    public String seeMenu(Model model){
        cartService = new CartService();
        Iterable<Food> iterable = foodService.findALlFood();
        List<Food> foods =
                StreamSupport.stream(iterable.spliterator(), false).toList();
        model.addAttribute("foods", foods);
        return "menu";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam int id){
        return "redirect:/menu";
    }
}
