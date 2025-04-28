package com.learning.annotations.Annotations.BeanScopes;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController // eager initialized
@Scope("singleton")
@RequestMapping("/api/")
public class MySimpleController {
//    @Autowired
//    User user;
//
//    @Autowired
//    Invoice invoice;

    @Autowired
    Order order;


    public MySimpleController(){
        System.out.println("MySimpleController initialized :"+this.hashCode());
    }

    @PostConstruct
    public void postConstruct(){
//        System.out.println("User object is null :" + Objects.isNull(user) + ", hash: "+user.hashCode());
//        System.out.println("Invoice object is null :"+Objects.isNull(invoice) + ", hash: "+invoice.hashCode());
        System.out.println("Order object is null :"+Objects.isNull(order) + ", hash: "+order.hashCode());
    }


    @GetMapping(path="/fetchDetails")
    public ResponseEntity<String> fetchDetails() {
        System.out.println("Order class Proxy i guess: "+order.getClass());
        order.dummyMethod();
        System.out.println("Order class real object: "+order.getClass()); // still the proxy class, but don't worry all req are handled by real object, its spring implementation that shows proxy up front
        return ResponseEntity.status(HttpStatus.OK).body("User details fetched");
    }

    @GetMapping(path="/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return ResponseEntity.status(HttpStatus.OK).body("loggedOut");
    }
}
