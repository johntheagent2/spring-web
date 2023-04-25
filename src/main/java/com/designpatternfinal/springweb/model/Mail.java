package com.designpatternfinal.springweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mail {
    private String sender = "caophat113@gmail.com";
    private String receiver;
    private String subject;
    private String body;


}
