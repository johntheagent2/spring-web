package com.designpatternfinal.springweb.repository;

import com.designpatternfinal.springweb.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findUserByUsername(String username);
}
