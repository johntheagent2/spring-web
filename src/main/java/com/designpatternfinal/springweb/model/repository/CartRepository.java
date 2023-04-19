package com.designpatternfinal.springweb.model.repository;

import com.designpatternfinal.springweb.model.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    public Cart getCartByAccount_Id(int id);
}
