package com.spring.oauth.oauthrest.repositories;


import com.spring.oauth.oauthrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
