package com.learning.annotations.Annotations.BeanScopes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Invoice {
    @Autowired
    User user;
    @PostConstruct
    public void postConstruct() {
        System.out.println("User hash from invoice: "+user.hashCode());
    }
    Invoice() {
        System.out.println("Invoice initialized hash: "+this.hashCode());
    }
}
