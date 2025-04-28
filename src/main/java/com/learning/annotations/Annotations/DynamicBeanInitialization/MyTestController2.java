package com.learning.annotations.Annotations.DynamicBeanInitialization;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController2 {
    @Autowired
    Bag bag;

    @Value("${db.url:no url provided}")
    String dbUrl;

    @Autowired
    TestBean TestBean;
    MyTestController2(@Value("${db.url:no url provided}") String url){
        System.out.println("This is my controller :"+url);
    }
    @PostConstruct
    public void checkBagStatus(){
        bag.checkBagStatus();
        System.out.println("DB url is :"+dbUrl);
    }
}
