package com.example.demo.entities;

import com.example.demo.models.Name;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private Name name;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles;
}
