package com.designpatternfinal.springweb.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(mappedBy = "foods")
    @JsonBackReference
    private Set<Order> foodOrders;
}
