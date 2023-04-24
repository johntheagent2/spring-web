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
    private String payment;
    private String status;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CartItem> cartItems;
}
