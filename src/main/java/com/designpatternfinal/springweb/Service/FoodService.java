package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Food;
import com.designpatternfinal.springweb.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService implements IService{
    @Autowired
    public FoodRepository foodRepository;
    @Override
    public void saveOrUpdate(Object o) {
        foodRepository.save((Food) o);
    }
    public void deleteFood(int id){
        foodRepository.deleteById(id);
    }

    public void updateFood(Food food){

    }
    public Iterable<Food> findALlFood(){
        return foodRepository.findAll();
    }

    public Food findFood(int id){
        return foodRepository.findByFid(id);
    }

}
