package com.designpatternfinal.springweb.model.repository;

import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.order.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Integer> {
    List<Order> findByPriceLessThan(int price);
}
