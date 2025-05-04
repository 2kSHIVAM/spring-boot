package com.learning.annotations.Annotations.StatusCode;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyStatusCodeTestController {
    @GetMapping("/addUser")
    public ResponseEntity<String> addUser(){
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id){
        System.out.println("User with id: "+id+" is updated");
        return ResponseEntity.status(HttpStatus.CREATED).build(); //builder design pattern either the body is user to construct the object or the build method is used
    }
}
