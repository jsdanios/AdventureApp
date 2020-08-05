package com.tts.AdventureApp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.AdventureApp.model.User;
import com.tts.AdventureApp.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    private final UserRepository userRepository = null;
 
    @RequestMapping("/user")
    public Principal user(Principal user) {
      return user;
    }
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}