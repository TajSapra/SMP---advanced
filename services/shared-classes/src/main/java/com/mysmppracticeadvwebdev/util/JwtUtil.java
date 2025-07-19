package com.mysmppracticeadvwebdev.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${jwt_secret}")
    private String secret;

    private final String USER_SUBJECT = "USER_DETAILS";

    private final String TOKEN_ISSUER = "MySMPApp";

    public String generateToken(String email, String id) throws IllegalArgumentException, JWTCreationException {
        long currentTime = new Date().getTime();
        long expiryTime = currentTime + (1000*60*60);
        return JWT
                .create()
                .withSubject(USER_SUBJECT)
                .withClaim("email", email)
                .withClaim("user_id", id)
                .withExpiresAt(new Date(expiryTime))
                .withIssuedAt(new Date(currentTime))
                .withIssuer(TOKEN_ISSUER)
                .sign(Algorithm.HMAC256(secret));
    }

    public Map<String, String> validateTokenAndRetrieveDetails(String token) throws TokenExpiredException {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withSubject(USER_SUBJECT)
                    .withIssuer(TOKEN_ISSUER)
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            Map<String, String> userDetails = new HashMap<>();

            userDetails.put("email", jwt.getClaim("email").asString());
            userDetails.put("user_id", jwt.getClaim("user_id").asString());

            return userDetails;
        } catch (TokenExpiredException ex) {
            // Token has expired
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token has expired", ex);
        } catch (JWTVerificationException ex) {
            // Any other verification error (invalid signature, malformed, etc.)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token", ex);
        }

    }
}
