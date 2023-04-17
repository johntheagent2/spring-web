package com.designpatternfinal.springweb.dto;

import com.designpatternfinal.springweb.model.User.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {
    private Account account;
}
