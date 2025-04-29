package com.learning.annotations.Annotations.Interceptors;

import org.springframework.stereotype.Component;

@Component
public class User {

    @MyCustomAnnotation(name="singh",key=2)
    public void getUser(){
        System.out.println("This is user class");
    }
}
