package com.learning.annotations.Annotations;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;


import java.beans.PropertyEditorSupport;

@Controller
@RequestMapping("/api")
public class SimpleController {

    @Autowired //although order is lazy and won't be created as soon as the app starts but the autowired annotation creates a bean if it is not created hence the bean is created even though it is lazy
    Order order;

    Payment payment; // since no autowired and payment is lazy hence its bean was not created

    SimpleController(){
        System.out.println("Constructor: Simple controller initialized");
    }

    @ResponseBody //we need this otherwise spring will treat my return statement as view name, we can avoid writing this if we replace @Controller with @RestController
    @GetMapping("/greet")
    public String hello(){
        return "Hi Shivam this side !";
    }

    @GetMapping("/student/{id}")
    @ResponseBody
    public String findUser(@PathVariable (name = "id") String id){
        return "User with id :"+id;
    }

    @GetMapping("/student")
    @ResponseBody
    public String findFirstAndLastName(@RequestParam (value = "firstName") String firstName,
                                       @RequestParam (value = "lastName") String lastName,
                                       @RequestParam (value = "id") int id) {
        return "User Firstname: "+ firstName + " and user Lastname: "+lastName + " with id: "+id;
    }

    @InitBinder
    protected void myBinder(DataBinder binder) {
        binder.registerCustomEditor(String.class, "firstName", new FirstNamePropertyEditor());
    }

    @GetMapping("/studentFirstName")
    public ResponseEntity<String> studentFirstName(@RequestParam (name = "firstName", required = false) String firstName) {
        String output = "Student First Name is :" + firstName;
        return ResponseEntity.status(HttpStatus.OK).body(output); //since returning this @ResponseBody is not required
    }

    @PostMapping("/myStudentDetails")
    @ResponseBody
    public String studentDetails(@RequestBody User user) {
        return "Username :"+user.userName+" and email :"+user.email;
    }

    @PostConstruct
    public void initialized(){
        System.out.println("Post construct: Simple controller is initialized");
    }

    @PreDestroy
    public void destroyBean(){
        System.out.println("Pre Destroy: Bye Bye !! See you");
    }
}

class FirstNamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String val) throws IllegalArgumentException {
        setValue(val.trim().toUpperCase());
    }
}

class User {
    @JsonProperty("user_name")
    String userName;
    String email;
    public void setUserName(String userName) {
        this.userName=userName;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getEmail() {
        return this.email;
    }
}