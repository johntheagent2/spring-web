package com.designpatternfinal.springweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_orders",
            joinColumns = {
                    @JoinColumn(name = "orders_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "food_id")
            })
    @JsonBackReference
    private Set<Food> foods;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;
}
