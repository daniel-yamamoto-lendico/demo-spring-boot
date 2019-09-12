package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PutMapping("/insertUser")
    public ResponseEntity insertUser(@RequestBody User user) {
        return ResponseEntity.accepted().body(userRepository.save(user));
    }
}
