package com.designpatternfinal.springweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Subscribers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    String email;
}
