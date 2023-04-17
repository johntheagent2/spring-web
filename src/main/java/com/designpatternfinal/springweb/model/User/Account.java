package com.designpatternfinal.springweb.model.User;

import com.designpatternfinal.springweb.model.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ACCOUNT_TABLE")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String phoneNum;
    private String role;
}
