package com.learning.annotations.Annotations.Aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AspectController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/fetchDetails")
    public ResponseEntity<String> fetchDetails() {
        System.out.println("Details got !");
        return ResponseEntity.status(HttpStatus.OK).body("User details fetched");
    }

    @GetMapping("/employeeDetails")
    public ResponseEntity<String> getEmployeeDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.employeeDetails(23,"Shivam"));
    }
}
