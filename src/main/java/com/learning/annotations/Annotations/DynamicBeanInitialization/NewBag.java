package com.learning.annotations.Annotations.DynamicBeanInitialization;

import jakarta.annotation.PostConstruct;

public class NewBag implements Bag {

    @Override
    public void checkBagStatus(){
        System.out.println("This is New Bag");
    }
}
