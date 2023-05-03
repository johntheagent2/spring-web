package com.designpatternfinal.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringWebApplication {
	public static void main(String[] args) throws IOException, InterruptedException{
		SpringApplication.run(SpringWebApplication.class, args);
	}

}
