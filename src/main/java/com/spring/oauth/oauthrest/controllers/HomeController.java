package com.spring.oauth.oauthrest.controllers;

import com.spring.oauth.oauthrest.entities.Role;
import com.spring.oauth.oauthrest.entities.User;
import com.spring.oauth.oauthrest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("")
    public String home(){
        return "Welcome to home";
    }

    @GetMapping("/private")
    public String privateArea(){
        return "Hello to private area";
    }


    @GetMapping("save")
    public User save(){
        if(userRepo.count()==0) {
            List<Role> temp_roles = new ArrayList<>();
            temp_roles.add(new Role("USER"));
            temp_roles.add(new Role("ACTUATOR"));
           return userRepo.save(new User("user", "user", temp_roles));
        }
        return null;
    }

}
