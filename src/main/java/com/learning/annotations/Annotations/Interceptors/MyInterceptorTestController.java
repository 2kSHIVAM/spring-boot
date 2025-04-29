package com.learning.annotations.Annotations.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyInterceptorTestController {

    @Autowired
    User user;

    @GetMapping("/fetchDetails")
    public void fetchDetails(){
        System.out.println("User details fetched");
    }

    @GetMapping("/getUser")
    public void getUser(){
        user.getUser();
    }

    @GetMapping("/deleteUser")
    public void deleteUser(){
        System.out.println("User deleted");
    }
}
