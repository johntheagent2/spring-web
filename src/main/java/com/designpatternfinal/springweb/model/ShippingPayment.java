package com.designpatternfinal.springweb.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
public class ShippingPayment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingid;

    @OneToOne
    @JoinColumn(name = "shipping_id")
    Order order;
}
