package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.model.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    public FoodRepository foodRepository;

    public void addFood(Food food){
        foodRepository.save(food);
    }

    public Iterable<Food> findALlFood(){
        return foodRepository.findAll();
    }
}
