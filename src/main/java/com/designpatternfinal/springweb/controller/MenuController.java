package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.AccountService;
import com.designpatternfinal.springweb.Service.CartService;
import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.dao.CartRequest;
import com.designpatternfinal.springweb.model.Cart;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.repository.CartRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

    List<Food> carts;

    @GetMapping
    public String seeMenu(Model model){
        if(carts == null){
            carts = new ArrayList<>();
        }
        Iterable<Food> iterable = foodService.findALlFood();
        List<Food> foods =
                StreamSupport.stream(iterable.spliterator(), false).toList();
        model.addAttribute("foods", foods);
        return "menu";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam int id, HttpServletRequest request){
        addToCartUsingSession(id, request);
        showCartInSession(request);
        return "redirect:/menu";
    }

    @GetMapping("/cart")
    public String showCart(Model model, HttpServletRequest request){
        List<Integer> currentItemInCart = showCartInSession(request);

        if(currentItemInCart == null) return "cart";

        List<Food> foods = new ArrayList<>();

        for(int i : currentItemInCart){
            foods.add(foodService.findFood(i));
        }
        model.addAttribute("foods", foods);
        return "cart";
    }

    public void addToCartUsingSession(int id, HttpServletRequest request){
        HttpSession session = request.getSession();

        List<Integer> listId= (List<Integer>) session.getAttribute("list");

        if(listId==null){
            listId =new ArrayList<>();
        }
        listId.add(id);

        session.setAttribute("list",listId);
    }

    public List<Integer> showCartInSession(HttpServletRequest request){
        HttpSession s1=request.getSession();
        List<Integer> list1= new ArrayList<>();

        list1= (ArrayList<Integer>)(s1.getAttribute("list"));
        return list1;
    }
}
