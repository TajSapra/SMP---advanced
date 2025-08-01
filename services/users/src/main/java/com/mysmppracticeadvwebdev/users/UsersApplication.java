package com.mysmppracticeadvwebdev.users;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mysmppracticeadvwebdev.entities")
@EnableJpaRepositories(basePackages = "com.mysmppracticeadvwebdev.users.repository")
@ComponentScan(basePackages = {
		"com.mysmppracticeadvwebdev.users",
		"com.mysmppracticeadvwebdev.shared",
		"com.mysmppracticeadvwebdev.util",
		"com.mysmppracticeadvwebdev.annotations",
		"com.mysmppracticeadvwebdev.messaging",
})
@EnableRabbit
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
