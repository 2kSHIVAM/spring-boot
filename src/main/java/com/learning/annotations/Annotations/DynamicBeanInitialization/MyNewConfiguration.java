package com.learning.annotations.Annotations.DynamicBeanInitialization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyNewConfiguration {

    @Bean
    //@Value("${user.bag.status}") // can be user here as well
    public Bag createBagBean(@Value("${user.bag.status}") boolean bagStatus) {
        if(bagStatus) {
            return new NewBag();
        } else
            return new OldBag();
    }

//    @Bean
    public
    TestBean myBean(){
        return new TestBean("test");
    }
}
