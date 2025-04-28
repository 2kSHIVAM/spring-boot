package com.learning.annotations.Annotations.UnsatisfiedDependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("onlineOrderPlacement")
public class OnlineOrderPlacement extends OrderPlacement{
    OnlineOrderPlacement(){
        System.out.println("This is online order placement");
    }
}
