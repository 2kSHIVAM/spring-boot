package com.learning.annotations.Annotations.UnsatisfiedDependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig2 {

    @Bean
    public User myUser1(){
        return new User("Shivam","2kshivamsingh@gmail.com");
    }

    @Primary
    @Bean
    public User myUser2(){
        return new User("Saksham","brother@gmail.com");
    }
}

class User{
    String name;
    String email;
    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void displayInfo(){
        System.out.println("Name: " + name + "\nEmail: " + email);
    }
}