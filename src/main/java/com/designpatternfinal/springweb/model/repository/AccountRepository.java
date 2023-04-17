package com.designpatternfinal.springweb.model.repository;

import com.designpatternfinal.springweb.model.User.Account;
import com.designpatternfinal.springweb.model.order.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findUserByUsername(String username);
}
