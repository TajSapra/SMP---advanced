package com.mysmppracticeadvwebdev.users.controller.v1;

import com.mysmppracticeadvwebdev.users.DTO.GetUserDTO;
import com.mysmppracticeadvwebdev.users.DTO.CreateUserDTO;
import com.mysmppracticeadvwebdev.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Map<String, Object> getUsers(){
        Map<String, Object> response = new HashMap<>();
        response.put("records", this.userService.getUsers());
        return response;
    }

    @PostMapping(path = "")
    public Map<String, Object> createUser(@RequestBody @Valid CreateUserDTO createUserDTO){
        Map<String, Object> response = new HashMap<>();
        response.put("created_user", this.userService.createUser(createUserDTO));
        return response;
    }

    @GetMapping(path = "/{id}")
    public GetUserDTO getUser(@PathVariable String id){
        System.out.println(id);
        return this.userService.getUser(id);
    }

    @PostMapping(path = "/authenticate")
    public Boolean authenticateUser(@RequestBody Map<String, String> loginCredentials){
        return this.userService.authenticateUser(loginCredentials);
    }
}
