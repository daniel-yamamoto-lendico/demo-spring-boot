package com.example.demo.controllers;

import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/findAll")
    public ResponseEntity getRoles() {
        return ResponseEntity.ok().body(roleRepository.findAll());
    }

    @PutMapping("/insert")
    public ResponseEntity insertRole(@RequestBody Role role) {
        return ResponseEntity.accepted().body(roleRepository.save(role));
    }
}
