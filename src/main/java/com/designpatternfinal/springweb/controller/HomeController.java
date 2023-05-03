package com.designpatternfinal.springweb.controller;
import com.designpatternfinal.springweb.Service.AccountService;
import com.designpatternfinal.springweb.Service.SubscriberService;
import com.designpatternfinal.springweb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    @Autowired
    AccountService accountService;
    @Autowired
    SubscriberService subscriberService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/")
    public String home(Model model){
        Account account = accountService.getCurrentAccount();
        model.addAttribute("account", account);
        return "home";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Account account){
        accountService.saveOrUpdate(account);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model){
        Account account = accountService.getCurrentAccount();
        model.addAttribute("account", account);

        return "profile";
    }

    @GetMapping("/subscribe")
    public String showProfile(){
        subscriberService.subscriberHandler();
        return "redirect:/profile";
    }
}
