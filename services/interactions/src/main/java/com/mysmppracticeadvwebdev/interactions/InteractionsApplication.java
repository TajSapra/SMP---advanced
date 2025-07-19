package com.mysmppracticeadvwebdev.interactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.mysmppracticeadvwebdev.entities")
@EnableJpaRepositories(basePackages = "com.mysmppracticeadvwebdev.interactions.repository")
@ComponentScan(basePackages = {
		"com.mysmppracticeadvwebdev.interactions",
		"com.mysmppracticeadvwebdev.shared"
})

@SpringBootApplication
public class InteractionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteractionsApplication.class, args);
	}

}
