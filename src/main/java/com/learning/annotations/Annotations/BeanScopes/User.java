package com.learning.annotations.Annotations.BeanScopes;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {

    User(){
    }
    @PostConstruct
    public void postConstruct() {
        System.out.println("User initialized hash (domain): "+this.hashCode());

    }
}
