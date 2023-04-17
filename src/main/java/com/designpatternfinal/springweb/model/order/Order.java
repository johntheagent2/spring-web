package com.designpatternfinal.springweb.model.order;

import com.designpatternfinal.springweb.model.Food;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ORDERS_TABLE")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private int oid;
    private String username;
    private int price;
    private String status;

    @ManyToMany(mappedBy = "foodOrders")
    private Set<Food> foods = new HashSet<>();
}
