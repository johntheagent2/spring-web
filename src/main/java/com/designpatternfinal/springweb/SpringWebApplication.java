package com.designpatternfinal.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

//	@Autowired
//	public AccountService db;
//	@Bean
//	public CommandLineRunner program(){
//		return args -> {
//			ArrayList<Account> s = new ArrayList<>();
//			s.add(new Account(0, "admin", "123", "Cao Duc Phat", "abcd", "1234567890", "ADMIN"));
//			s.add(new Account(0, "admin1", "123", "Vo Dinh Chuong", "abcde", "0987654321", "ADMIN"));
//			s.add(new Account(0, "user", "123", "Vo Pham Quoc Thai", "abcdvasd", "1234567890", "USER"));
//
//			for(Account a : s){
//				db.addAccount(a);
//			}
//
//			System.out.println("Added Successfully!");
//		};
//	}
}
