package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rs.fer")
public class FERSpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FERSpringBootJpaApplication.class, args);
	}

}
