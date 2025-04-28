package com.learning.annotations.Annotations;

import com.learning.annotations.Annotations.BeanPractice.Gateway;
import com.learning.annotations.Annotations.BeanPractice.Invoice;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class  Order {

    Order(){
        System.out.println("Order is initialized");
    }
}
