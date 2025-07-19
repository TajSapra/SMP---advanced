package com.mysmppracticeadvwebdev.users.UtilServices;

import com.mysmppracticeadvwebdev.entities.UserEntity;
import com.mysmppracticeadvwebdev.users.DTO.GetUserDTO;
import com.mysmppracticeadvwebdev.users.repository.UserRepository;
import com.mysmppracticeadvwebdev.util.AuthVerifier;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthVerifierImpl implements AuthVerifier {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void verifyUser(Map<String, String> user_details) {
        String email = user_details.get("email");
        String user_id = user_details.get("user_id");

        UserEntity user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getEmail().equals(email) && !user.getId().equals(user_id)){
            throw new RuntimeException("Invalid user");
        }

        request.setAttribute("user", modelMapper.map(user, GetUserDTO.class));
    }
}
