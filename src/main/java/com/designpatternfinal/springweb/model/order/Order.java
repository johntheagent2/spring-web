package com.designpatternfinal.springweb.model.order;

import com.designpatternfinal.springweb.model.Food;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private String username;
    private int price;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "customer_orders",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    @JsonManagedReference
    private Set<Food> foods;
}
