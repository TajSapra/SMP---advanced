package com.mysmppracticeadvwebdev.posts.Configuration;

import com.mysmppracticeadvwebdev.entities.PostEntity;
import com.mysmppracticeadvwebdev.entities.UserEntity;
import com.mysmppracticeadvwebdev.posts.DTO.GetPostsDTO;
import com.mysmppracticeadvwebdev.posts.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
