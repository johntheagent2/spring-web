package com.designpatternfinal.springweb.controller;

import com.designpatternfinal.springweb.Service.*;

import com.designpatternfinal.springweb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    OrderService orderService;
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    ShippingPaymentService shippingPaymentService;
    @Autowired
    PickupPaymentService pickupPaymentService;
    @Autowired
    AccountService accountService;

    @GetMapping
    public String seeAdminPage(Model model){
        Iterable<Order> iterable = orderService.getAll();
        List<Order> orderList =
                StreamSupport.stream(iterable.spliterator(), false).toList();

        List<Order> shippingOrderList = new ArrayList<>();

        for(Order order : orderList){
            if(!order.getStatus().equals("Done")){
                shippingOrderList.add(order);
            }
        }

        model.addAttribute("account", accountService.getCurrentAccount());
        model.addAttribute("orderList", shippingOrderList);
        return "admin";
    }

    @GetMapping ("/admin_shipping")
    public String seeAdminShipping(Model model){
        Iterable<ShippingPayment> iterable = shippingPaymentService.getAll();
        List<ShippingPayment> orderList =
                StreamSupport.stream(iterable.spliterator(), false).toList();

        List<Order> shippingOrderList = new ArrayList<>();

        for(ShippingPayment shippingPayment : orderList){
            shippingOrderList.add(shippingPayment.getOrder());
        }

        model.addAttribute("orderList", shippingOrderList);
        return "admin_shipping";
    }

    @GetMapping ("/admin_pickup")
    public String seeAdminPickup(Model model){
        Iterable<PickupPayment> iterable = pickupPaymentService.getAll();
        List<PickupPayment> orderList =
                StreamSupport.stream(iterable.spliterator(), false).toList();

        List<Order> shippingOrderList = new ArrayList<>();

        for(PickupPayment shippingPayment : orderList){
            shippingOrderList.add(shippingPayment.getOrder());
        }

        model.addAttribute("orderList", shippingOrderList);
        return "admin_pickup";
    }

    @GetMapping ("/admin_ready")
    public String seeAdminReady(Model model){
        Iterable<Order> iterable = orderService.getAll();
        List<Order> orderList =
                StreamSupport.stream(iterable.spliterator(), false).toList();

        List<Order> shippingOrderList = new ArrayList<>();

        for(Order order : orderList){
            if(order.getStatus().equals("Ready")){
                shippingOrderList.add(order);
            }
        }

        model.addAttribute("orderList", shippingOrderList);
        return "admin_ready";
    }

    @GetMapping("/send_mail")
    public String sendMailUpdateForSubscriber(){
        return "/send_mail";
    }

    @GetMapping("/mail_sent")
    public String sendMailUpdateForSubscriberPost(@RequestParam String updateText){
        subscriberService.notifySubscribers(updateText);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String updateStatusOfOrder(@RequestParam int id){
        Order order = orderService.findOrderByOrderID(id);
        System.out.println(order.getOid() + order.getUsername());
        switch (order.getStatus()) {
            case "Pending" -> {
                order.setStatus("In Kitchen");
                orderService.saveOrUpdate(order);
                return "redirect:/admin";
            }
            case "In Kitchen" -> {
                order.setStatus("Ready");
                orderService.saveOrUpdate(order);
                return "redirect:/admin";
            }
            case "Ready" -> {
                order.setStatus("Done");
                orderService.saveOrUpdate(order);
                return "redirect:/admin";
            }
        }

        return "redirect:/admin";
    }
}
