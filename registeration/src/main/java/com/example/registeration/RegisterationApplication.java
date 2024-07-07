package com.example.registeration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.registeration.model")
public class RegisterationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterationApplication.class, args);
	}

}
