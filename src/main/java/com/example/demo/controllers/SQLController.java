package com.example.demo.controllers;

import com.example.demo.models.SQLStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@RestController
@RequestMapping("/sql")
public class SQLController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("run")
    public ResponseEntity runSql(@RequestBody SQLStatement sqlStatement) {
        Query query = entityManager.createNativeQuery(sqlStatement.getSql());
        return ResponseEntity.ok().body(query.getResultList());
    }

}
