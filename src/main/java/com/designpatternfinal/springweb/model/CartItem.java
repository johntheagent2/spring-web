package com.designpatternfinal.springweb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemID;
    private int quantity;
    private int price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    private Order order;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productId", referencedColumnName = "fid")
    private Food food;
}
