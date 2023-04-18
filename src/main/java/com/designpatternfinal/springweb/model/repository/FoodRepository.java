package com.designpatternfinal.springweb.model.repository;

import com.designpatternfinal.springweb.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
}
