package com.mysmppracticeadvwebdev.users.service;

import com.mysmppracticeadvwebdev.users.DTO.UserDTO;
import com.mysmppracticeadvwebdev.users.entity.UserEntity;
import com.mysmppracticeadvwebdev.users.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<UserDTO> getUsers(){
        return this.userRepository.findAll()
                .stream()
                .map(userEntity -> this.modelMapper.map(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO){
        UserEntity savedUser = this.userRepository.save(modelMapper.map(userDTO, UserEntity.class));
        System.out.println(userDTO);
        System.out.println(savedUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }

}
