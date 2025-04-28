package com.learning.annotations.Annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Bean
    @Lazy
    public Payment myPaymentBean(){
        return new Payment("-1");
    }
}
