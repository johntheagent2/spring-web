package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.*;
import com.designpatternfinal.springweb.model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
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
    @Autowired
    PaymentService paymentService;

    @GetMapping
    public String seeMenu(Model model){
        if(carts == null){
            carts = new ArrayList<>();
        }
        Iterable<Food> iterable = foodService.getAll();
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
        List<Food> currentItemInCart = showCartInSession(request);
        int totalPrice = 0;
        List<Food> foods = new ArrayList<>();

        for(Food food : currentItemInCart){
            if(foods.contains(food)){
                food.setQuantity(food.getQuantity() + 1);
            }else{
                foods.add(food);
            }
        }

        for(Food food : foods){
            food.setPrice(food.getPrice() * food.getQuantity());
            totalPrice = totalPrice + food.getPrice();
        }

        model.addAttribute("account", accountService.getCurrentAccount());
        model.addAttribute("foods", foods);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @GetMapping("/cart_delete")
    public String deleteCartItem(@RequestParam("id") int id, HttpServletRequest request){
        HttpSession s1=request.getSession();

        List<Integer> list= (ArrayList<Integer>)(s1.getAttribute("list"));
        for(Integer idInList : list){
            if(idInList == id){
                list.remove(idInList);
                break;
            }
        }

        s1.setAttribute("list",list);
        return "redirect:/menu/cart";
    }

    @GetMapping("/checkout")
    public String checkoutCart(HttpServletRequest request, @RequestParam("radioName") String receiveFood){
        List<Food> currentItemInCart = showCartInSession(request);

        int totalPrice = 0;

        for(Food food : currentItemInCart){
            totalPrice = totalPrice + food.getPrice();
        }

        Set<CartItem> cartItemSet = new HashSet<>();

        for(Food food : currentItemInCart){
            int flag = 0;
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(Collections.frequency(currentItemInCart, food));
            cartItem.setPrice(food.getPrice());
            cartItem.setFood(food);
            for(CartItem cartItemCheck : cartItemSet){
                if(cartItemCheck.getFood().getFoodName().equals(cartItem.getFood().getFoodName())){
                    flag++;
                }
            }
            if(flag == 0)
                cartItemSet.add(cartItem);
        }


        Order order = new Order();
        order.setCartItems(cartItemSet);

        order.setUsername(accountService.getCurrentAccount().getUsername());
        order.setStatus("Pending");
        order.setPrice(totalPrice);

        paymentService.processOrder(order, receiveFood);

        HttpSession session = request.getSession();
        session.removeAttribute("list");
        return "redirect:/menu";
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


    public List<Food> showCartInSession(HttpServletRequest request){
        HttpSession s1=request.getSession();

        List<Integer> list1= (ArrayList<Integer>)(s1.getAttribute("list"));

        List<Food> foodList = new ArrayList<>();

        if(list1 == null)
            return foodList;

        for(Integer list : list1){
                foodList.add(foodService.findFood(list));
        }
        return foodList;
    }
}
