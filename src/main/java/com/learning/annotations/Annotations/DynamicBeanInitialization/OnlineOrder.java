package com.learning.annotations.Annotations.DynamicBeanInitialization;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("onlineOrderCheck")
public class OnlineOrder implements BaseOrder{

    @Override
    public void createOrder(){
        System.out.println("Oline order created !");
    }
}
