package com.learning.annotations.Annotations.UnsatisfiedDependency;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SetOrder {

    @Autowired
    OrderPlacement orderPlacement;

    @Qualifier("myUser2")
    @Autowired
    User user;

    SetOrder(){
        System.out.println("This is set order calling !!");
    }
    @PostConstruct
    public void checkPlacementTypeAndUser(){
        System.out.println("Post construct calling for Set order :" + orderPlacement.getClass());
        user.displayInfo();
    }
}
