package com.learning.annotations.Annotations.DynamicBeanInitialization;

import jakarta.annotation.PostConstruct;

public class OldBag implements Bag{
    @Override
    public void checkBagStatus() {
        System.out.println("This is Old Bag.");
    }
}
