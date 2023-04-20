package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Cart;
import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.repository.AccountRepository;
import com.designpatternfinal.springweb.model.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public AccountService accountService;

    public void addOrSave(Cart cart){
        cartRepository.save(cart);
    }
}
