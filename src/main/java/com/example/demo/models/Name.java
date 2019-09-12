package com.example.demo.models;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Name {

    private String firstName;
    private String lastName;

}
