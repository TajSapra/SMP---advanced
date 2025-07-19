package com.mysmppracticeadvwebdev.users.service;

import com.mysmppracticeadvwebdev.users.DTO.GetUserDTO;
import com.mysmppracticeadvwebdev.users.DTO.CreateUserDTO;
import com.mysmppracticeadvwebdev.entities.UserEntity;
import com.mysmppracticeadvwebdev.users.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<GetUserDTO> getUsers(){
        return this.userRepository.findAll()
                .stream()
                .map(userEntity -> this.modelMapper.map(userEntity, GetUserDTO.class))
                .collect(Collectors.toList());
    }

    public CreateUserDTO createUser(CreateUserDTO createUserDTO){
        UserEntity savedUser = this.userRepository.save(modelMapper.map(createUserDTO, UserEntity.class));
        return modelMapper.map(savedUser, CreateUserDTO.class);
    }

    public GetUserDTO getUser(String id){
        Optional<UserEntity> foundUser = this.userRepository.findById(id);
        if(foundUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found");
        }
        return modelMapper.map(foundUser.get(), GetUserDTO.class);
    }

    public Boolean authenticateUser(Map<String, String> loginCredentials) {
        Optional<UserEntity> foundUser = this.userRepository.findByEmail(loginCredentials.get("email"));
        if(foundUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        UserEntity foundUserEntity = foundUser.get();
        if(loginCredentials.get("password").equals(foundUserEntity.getPassword())){
            return true;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect Password");
    }
}
