package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends UsernamePasswordAuthFilter{
    private AuthenticationFilter authenticationFilter;

    public JWTAuthenticationFilter( AuthenticationFilter authenticationFilter){
        this.authenticationFilter = authenticationFilter;
    }

    public Authentication attemptAuthentication (HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException{

        try {
            ApplicationUser creds = new ObjectMapper().readValue(request.getInputStream(),ApplicationUser.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
