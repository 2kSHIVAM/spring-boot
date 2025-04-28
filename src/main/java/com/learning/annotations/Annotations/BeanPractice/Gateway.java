package com.learning.annotations.Annotations.BeanPractice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class Gateway {

    @Autowired
    Invoice invoice;
    public Gateway(){
        System.out.println("Gateway initialised");
    }

    @PostConstruct
    public void initializeGateWay(){
        System.out.println("Initializing gateway for invoice");
        invoice.setGateway(this);
    }
}
