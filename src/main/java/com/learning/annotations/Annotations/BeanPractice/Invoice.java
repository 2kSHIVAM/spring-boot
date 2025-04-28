package com.learning.annotations.Annotations.BeanPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

    Gateway gateway;
    public Invoice(){
        System.out.println("Invoice Initialized");
    }
    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }
}
