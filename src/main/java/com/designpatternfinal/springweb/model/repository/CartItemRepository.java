package com.designpatternfinal.springweb.model.repository;

import com.designpatternfinal.springweb.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}
