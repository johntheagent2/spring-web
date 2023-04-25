package com.designpatternfinal.springweb.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
public class PickupPayment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @OneToOne
    @JoinColumn(name = "pickup_id")
    Order order;
}
