package com.designpatternfinal.springweb.model.User;

import com.designpatternfinal.springweb.dto.OrderRequest;
import com.designpatternfinal.springweb.model.order.Order;
import com.designpatternfinal.springweb.model.repository.AccountRepository;
import com.designpatternfinal.springweb.model.repository.FoodRepository;
import com.designpatternfinal.springweb.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private AccountRepository accountRepository;

    public void addAccount(Account account){
        String hash = encoder.encode(account.getPassword());
        account.setPassword(hash);
        accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findUserByUsername(username);
        if(account == null)
            throw new UsernameNotFoundException("User not found");
        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

//    public Account placeOrder(@RequestBody OrderRequest orderRequest){
//        return accountRepository.save(orderRequest.getAccount());
//    }
//
//    public Order saveOrderWithFoods(@RequestBody Order order){
//        return orderRepository.save(order);
//    }
//
////    public List<Order> findAllOrders(){
////        return (List<Order>) orderRepository.findAll();
////    }
//
//    public List<Account> findAllOrders(){
//        return (List<Account>) accountRepository.findAll();
//    }
}
