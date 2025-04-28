package com.learning.annotations.Annotations.DynamicBeanInitialization;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyTestController {

    @Autowired
    @Qualifier("onlineOrderCheck")
    BaseOrder onlineOrder;

    @Autowired
    @Qualifier("offlineOrderCheck")
    BaseOrder offlineOrder;

    MyTestController(){
    }

    @PostConstruct
    public void init (){
        System.out.println("The controller initialized");
    }

    @GetMapping("/placeOrder")
    public String placeOrder(@RequestParam(value = "isOnlineOrder", required = false) Boolean isOnlineOrder) {
        if(isOnlineOrder) {
            onlineOrder.createOrder();
        } else{
            offlineOrder.createOrder();
        }
        return "Please check logs lol :)";
    }
}
