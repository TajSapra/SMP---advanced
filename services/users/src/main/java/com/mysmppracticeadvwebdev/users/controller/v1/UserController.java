package com.mysmppracticeadvwebdev.users.controller.v1;

import com.mysmppracticeadvwebdev.users.DTO.UserDTO;
import com.mysmppracticeadvwebdev.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public Map<String, Object> createUser(@RequestBody @Valid UserDTO userDTO){
        Map<String, Object> response = new HashMap<>();
        response.put("created_user", this.userService.createUser(userDTO));
        return response;
    }


}
