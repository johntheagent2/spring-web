package com.designpatternfinal.springweb.model;


import com.designpatternfinal.springweb.model.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FOODS_TABLE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private String foodName;
    @Column(name="valueDesc")
    private String desc;
    @Column(name="valuePrice")
    private int price;

    @ManyToMany
    @JoinTable(
            name = "customer_orders",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private Set<Order> foodOrders = new HashSet<>();
}
