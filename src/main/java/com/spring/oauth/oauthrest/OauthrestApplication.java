package com.spring.oauth.oauthrest;

import com.spring.oauth.oauthrest.entities.Role;
import com.spring.oauth.oauthrest.entities.User;
import com.spring.oauth.oauthrest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OauthrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthrestApplication.class, args);

    }


}
