package com.designpatternfinal.springweb.repository;

import com.designpatternfinal.springweb.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
    public Food findByFid(int fid);
}
