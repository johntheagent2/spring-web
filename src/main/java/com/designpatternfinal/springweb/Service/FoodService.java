package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService extends IService<Food> {
    @Autowired
    public FoodRepository foodRepository;
    @Override
    public void saveOrUpdate(Food food) {
        foodRepository.save(food);
    }
    public void deleteFood(int id){
        foodRepository.deleteById(id);
    }
    public Iterable<Food> getAll(){
        return foodRepository.findAll();
    }
    public Food findFood(int id){
        return foodRepository.findByFid(id);
    }

}
