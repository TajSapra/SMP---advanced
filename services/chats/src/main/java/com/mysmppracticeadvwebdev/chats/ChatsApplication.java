package com.mysmppracticeadvwebdev.chats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mysmppracticeadvwebdev.entities")
@EnableJpaRepositories(basePackages = "com.mysmppracticeadvwebdev.chats.repository")
@ComponentScan(basePackages = {
		"com.mysmppracticeadvwebdev.chats",
		"com.mysmppracticeadvwebdev.shared"
})
public class ChatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatsApplication.class, args);
	}

}
