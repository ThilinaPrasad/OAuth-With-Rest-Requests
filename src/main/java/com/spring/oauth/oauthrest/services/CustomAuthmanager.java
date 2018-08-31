package com.spring.oauth.oauthrest.services;


import com.spring.oauth.oauthrest.entities.Role;
import com.spring.oauth.oauthrest.entities.User;
import com.spring.oauth.oauthrest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomAuthmanager implements AuthenticationManager {

    @Autowired
    UserRepo userRepo;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        User user = userRepo.findByUsername(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                List<Role> roles = user.getRoles();
                return new UsernamePasswordAuthenticationToken(username, password, roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
            }else {
                throw new BadCredentialsException("Credentials doesn't match!");
            }
        }
        else {
            throw  new BadCredentialsException("User not found!");
        }
    }
}
