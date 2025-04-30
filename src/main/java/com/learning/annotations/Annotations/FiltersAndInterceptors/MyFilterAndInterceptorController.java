package com.learning.annotations.Annotations.FiltersAndInterceptors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyFilterAndInterceptorController {

    @GetMapping("/userDetails")
    public void getUserDetails(){
        System.out.println("User details fetched");
    }
}
