package com.mysmppracticeadvwebdev.storage;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.mysmppracticeadvwebdev.entities")
@EnableJpaRepositories(basePackages = "com.mysmppracticeadvwebdev.storage.repository")
@ComponentScan(basePackages = {
		"com.mysmppracticeadvwebdev.storage",
		"com.mysmppracticeadvwebdev.shared",
		"com.mysmppracticeadvwebdev.messaging",
		"com.mysmppracticeadvwebdev.util",
		"com.mysmppracticeadvwebdev.annotations"
})
@SpringBootApplication
@EnableRabbit
public class StorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);
	}

}
