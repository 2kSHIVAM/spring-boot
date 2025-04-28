package com.learning.annotations.Annotations.ConditionalOnProperty;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MyTestController {

    @Autowired(required = false)
    MySqlConnector mySqlConnector;

    @Autowired(required = false)
    NoSqlConnector noSqlConnector;

    @PostConstruct
    public void init(){
        System.out.println("My sql connector is null: "+ Objects.isNull(mySqlConnector));
        System.out.println("My no sql connector is null: "+Objects.isNull(noSqlConnector));
    }



}
