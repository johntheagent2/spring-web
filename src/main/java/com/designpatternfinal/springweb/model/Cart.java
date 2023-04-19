package com.designpatternfinal.springweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_acc_id")
    private Account account;

    @OneToMany(targetEntity = Food.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cf_fk", referencedColumnName = "cartId")
    private Set<Food> foodsInCart = new HashSet<>();

}
