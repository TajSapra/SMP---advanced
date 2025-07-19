package com.mysmppracticeadvwebdev.aspects;

import com.mysmppracticeadvwebdev.util.AuthVerifier;
import com.mysmppracticeadvwebdev.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthVerifier authVerifier;

    @Pointcut("@annotation(com.shared.annotations.RequireAuth)")
    public void requireAuthPointcut() {}

    @Before("requireAuthPointcut()")
    public void authorize() {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);
        Map<String, String> user_details = jwtUtil.validateTokenAndRetrieveDetails(token);

        request.setAttribute("user_details", user_details);

        authVerifier.verifyUser(user_details);
    }
}
