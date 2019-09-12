package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PutMapping("/insert")
    public ResponseEntity insertUser(@RequestBody User user) {
        return ResponseEntity.accepted().body(userRepository.save(user));
    }
}
