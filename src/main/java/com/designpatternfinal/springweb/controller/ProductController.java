package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.dto.OrderRequest;
import com.designpatternfinal.springweb.model.User.Account;
import com.designpatternfinal.springweb.model.User.AccountService;
import com.designpatternfinal.springweb.model.order.Order;
import com.designpatternfinal.springweb.model.repository.AccountRepository;
import com.designpatternfinal.springweb.model.repository.FoodRepository;
import com.designpatternfinal.springweb.model.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class ProductController {

//    @PostMapping
//    public Order saveOrderWithFoods(@RequestBody Order order){
//        return new AccountService().saveOrderWithFoods(order);
//    }
//
//    @PostMapping("/placeorder")
//    public Account placeOrder(@RequestBody OrderRequest orderRequest){
//        return new AccountService().placeOrder(orderRequest);
//    }
//
//    @GetMapping("/findallorders")
//    public List<Account> findAllOrders(){
//        return new AccountService().findAllOrders();
//    }
}
