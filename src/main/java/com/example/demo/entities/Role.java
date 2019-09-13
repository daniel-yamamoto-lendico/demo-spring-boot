package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@Table(name = "roles")
@NoArgsConstructor
public class Role {

    @Id
    @NotBlank
    private String roleName;

    public Role(final String roleName) {
        this.roleName = roleName;
    }
}
