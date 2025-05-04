package com.learning.annotations.Annotations.JPA_PART1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyJPATestController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/createUserTable")
    public String createUserTable(){
        userDAO.createTable();
        return "Table created successfully";
    }

    // here we can user @PathVariable, @RequestParam, @RequestBody (here you can use User class as parameter by sending its fields in json from client)
    @PostMapping("/addUser/{id}-{userName}")
    public String addUser(@PathVariable int id, @PathVariable String userName ){
        userDAO.createUser(userName, id);
        return "User created successfully";
    }

    @GetMapping("/getAllUsers")
    public String getAllUsers(){
        userDAO.readUsers();
        return "All users displayed on terminal !";
    }
}
