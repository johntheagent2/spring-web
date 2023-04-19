package com.designpatternfinal.springweb.model;

import com.designpatternfinal.springweb.model.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    List<Food> foodsInCart = new ArrayList<>();

    public void addToCart(Food food){
        foodsInCart.add(food);
    }
}
