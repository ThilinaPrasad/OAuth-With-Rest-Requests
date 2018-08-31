package com.spring.oauth.oauthrest.services;


import com.spring.oauth.oauthrest.entities.CustomUserDetails;
import com.spring.oauth.oauthrest.entities.Role;
import com.spring.oauth.oauthrest.entities.User;
import com.spring.oauth.oauthrest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return new CustomUserDetails(userRepo.findByUsername(s));
    }
}
