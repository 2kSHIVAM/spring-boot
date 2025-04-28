package com.learning.annotations.Annotations.BeanScopes;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Order {

    public Order(){
        System.out.println("Order is initialized constructor");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Order initialized (domain) :"+this.hashCode());
    }
    public void dummyMethod(){
        System.out.println("Dummy method called");
    }
}
