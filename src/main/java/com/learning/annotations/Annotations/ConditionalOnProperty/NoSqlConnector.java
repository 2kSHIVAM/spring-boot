package com.learning.annotations.Annotations.ConditionalOnProperty;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "shivam",value = "singh2",havingValue = "Best Coder2",matchIfMissing = false)
public class NoSqlConnector {

    @PostConstruct
    public void init(){
        System.out.println("Doing some initialization here !");
    }
}
