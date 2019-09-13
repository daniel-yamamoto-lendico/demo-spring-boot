package com.example.demo.controllers;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/findAll")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PutMapping("/insert")
    public ResponseEntity insertUser(@RequestBody User user) {
        List<Role> r = new ArrayList<>(), roles = user.getRoles();
        for (Role role : roles)
        {
            role = roleRepository.findByRoleName(role.getRoleName());
            r.add(role);
        }
        user.setRoles(r);
        return ResponseEntity.accepted().body(userRepository.save(user));
    }
}
