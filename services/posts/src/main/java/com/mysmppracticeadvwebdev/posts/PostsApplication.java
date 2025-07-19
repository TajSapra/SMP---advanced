package com.mysmppracticeadvwebdev.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mysmppracticeadvwebdev.entities")
@EnableJpaRepositories(basePackages = "com.mysmppracticeadvwebdev.posts.repository")
@ComponentScan(basePackages = {
		"com.mysmppracticeadvwebdev.posts",
		"com.mysmppracticeadvwebdev.shared"
})public class PostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostsApplication.class, args);
	}

}
