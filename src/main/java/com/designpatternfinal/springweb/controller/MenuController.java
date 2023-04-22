package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.AccountService;
import com.designpatternfinal.springweb.Service.CartService;
import com.designpatternfinal.springweb.Service.FoodService;
import com.designpatternfinal.springweb.Service.OrderService;
import com.designpatternfinal.springweb.dao.CartRequest;
import com.designpatternfinal.springweb.model.Cart;
import com.designpatternfinal.springweb.model.CartItem;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.Order;
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
import java.util.Set;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    FoodService foodService;

    @Autowired
    AccountService accountService;

    @Autowired
    OrderService orderService;

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
            if(foods.contains(foodService.findFood(i)))
            {
                for(Food getFood : foods){
                    if(getFood.getFoodName().equals(foodService.findFood(i).getFoodName())){
                        getFood.setQuantity(getFood.getQuantity() + 1);
                    }
                }
            }
            else foods.add(foodService.findFood(i));
        }

        for(Food food : foods){
            food.setPrice(food.getPrice() * food.getQuantity());
        }

        model.addAttribute("foods", foods);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkoutCart(HttpServletRequest request){
        List<Integer> currentItemInCart = showCartInSession(request);

        List<Food> foods = new ArrayList<>();

        for(int i : currentItemInCart){
            if(foods.contains(foodService.findFood(i)))
            {
                for(Food getFood : foods)
                    if(getFood.getFoodName().equals(foodService.findFood(i).getFoodName())){
                        getFood.setQuantity(getFood.getQuantity() + 1);
                    }
            }
            else foods.add(foodService.findFood(i));
        }

        int totalPrice = 0;

        for(Food food : foods){
            food.setPrice(food.getPrice() * food.getQuantity());
            totalPrice = totalPrice + food.getPrice();
        }

        Order order = new Order();

        Set<CartItem> cartItemSet = new HashSet<>();

        for(Food food : foods){
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(food.getQuantity());
            cartItem.setPrice(food.getPrice());
            cartItemSet.add(cartItem);
        }
        order.setCartItems(cartItemSet);

        Set<Food> foodSet = new HashSet<>(foods);

        order.setUsername(accountService.getCurrentAccount().getUsername());
        order.setStatus("placed");
        order.setPrice(totalPrice);

        orderService.saveOrUpdate(order);
        System.out.println(order.getPrice());
        return "redirect:/menu";
    }

    public int getQuantity(HttpServletRequest request){
        List<Integer> currentItemInCart = showCartInSession(request);

        List<Food> foods = new ArrayList<>();

        int quantity = 1;

        for(int i : currentItemInCart){
            if(foods.contains(foodService.findFood(i)))
            {
                for(Food getFood : foods)
                    if(getFood.getFoodName().equals(foodService.findFood(i).getFoodName())){
                        quantity = quantity + 1;
                    }
            }
            else foods.add(foodService.findFood(i));
        }
        return quantity;
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
