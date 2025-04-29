package com.learning.annotations.Annotations.Interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MyCustomAnnotationInterceptor {
    @Around("@annotation(com.learning.annotations.Annotations.Interceptors.MyCustomAnnotation)")
    public void methodCustomInterceptor(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("This is method custom interceptor, around started");
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        if(method.isAnnotationPresent(MyCustomAnnotation.class)){
            MyCustomAnnotation myCustomAnnotation = method.getAnnotation(MyCustomAnnotation.class);
            System.out.println(myCustomAnnotation.name()+"--"+myCustomAnnotation.key());
        }
        joinPoint.proceed();
        System.out.println("Around completed");
    }
}
