package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Account;
import com.designpatternfinal.springweb.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AccountRepository accountRepository;

    public void saveOrUpdate(Account account){
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

}
