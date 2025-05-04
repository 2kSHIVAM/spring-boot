package com.learning.annotations.Annotations.JPA_PART1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class MyJPATestController2 {

    @Autowired
    UserService userService;

    @GetMapping("/createUserTable")
    public String createUserTable(){
        return userService.createUserTable();
    }

    @PostMapping("/addUser/{age}-{userName}")
    public String addUser(@PathVariable int age, @PathVariable String userName){
        return userService.addUser(userName, age);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getAllUserNames")
    public List<String> getAllUserNames(){
        return userService.getAllsUserNames();
    }

    @GetMapping("/getUsersCounts")
    public int getUsersCounts(){
        return userService.getUsersCounts();
    }
}
