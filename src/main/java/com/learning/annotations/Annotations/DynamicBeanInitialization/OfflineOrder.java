package com.learning.annotations.Annotations.DynamicBeanInitialization;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("offlineOrderCheck")
public class OfflineOrder implements BaseOrder{
    @Override
    public void createOrder() {
        System.out.println("Offline order created !");
    }
}
