package com.designpatternfinal.springweb.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        System.out.println("Dang xuat thanh cong");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpServletResponse resp){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        try{
//            Authentication success = auth.authenticate(token);
            System.out.println("Dang nhap thanh cong");

//            SecurityContextHolder.getContext().setAuthentication(success);
            return "redirect:/";

        }catch (BadCredentialsException e){
            model.addAttribute("error", "BadCredential Exception");
        }catch (LockedException e){
            model.addAttribute("error", "Locked Exception");
        }catch (DisabledException e){
            model.addAttribute("error", "Disabled Exception");
        }catch (AccountExpiredException e){
            model.addAttribute("error", "Account Expired Exception");
        }
        return "login";
    }
}
