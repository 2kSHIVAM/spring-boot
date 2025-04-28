package com.learning.annotations.Annotations.DynamicBeanInitialization;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

    //we need a default constructor for case if we want to expose it as component/bean and already have a parametrized constructor
    TestBean(){

    }
    TestBean(String test) {
        System.out.println("test bean it is !");
    }
}
