package com.learning.annotations.Annotations.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Aspect
@Component
public class AspectLogging {
    @Before("execution(public * com.learning.annotations.Annotations.Aspects..*(..))") //any package and subpackage with any method with any number of parameters and any return type
    public void beforeLogging() {
        System.out.println("Before logging logged 1!!");
    }


    @Before("target(com.learning.annotations.Annotations.Aspects.AspectController)")  // all methods in a class instance
    public void beforeLogging2() {
        System.out.println("Before logging logged 2!!");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeLogging3() {
        System.out.println("Before logging logged 3!!");
    }

    @Before("args(int,String)")
    public void beforeLogging4() {
        System.out.println("Before logging logged 4!!");
    }


    @Before("within(com.learning.annotations.Annotations.Aspects..*)") //will run for all the methods in the package and subpackages
    public void beforeLogging5() {
        System.out.println("Before logging logged 5!!");
    }

    @Before("within(com.learning.annotations.Annotations.Aspects.AspectController)") // will run for all the method in a class
    public void beforeLogging6() {
        System.out.println("Before logging logged 6!!");
    }

    @Before("@within(org.springframework.web.bind.annotation.RestController)") // will run for any method int the class with this annotation
    public void beforeLogging7() {
        System.out.println("Before logging logged 7!!");
    }

    @Before("within(com.learning.annotations.Annotations.Aspects.AspectController)"
            +
            "&& @within(org.springframework.web.bind.annotation.RestController)")
    public void beforeLogging8() {
        System.out.println("Before logging logged 8!!");
    }

    @Before("within(com.learning.annotations.Annotations.Aspects.AspectController)"
            +
            "&& @within(org.springframework.web.bind.annotation.RestController)")
    public void beforeLogging9() {
        System.out.println("Before logging logged 9!!");
    }

    @Before("within(com.learning.annotations.Annotations.Aspects.EmployeeService)"
            +
            "&& @within(org.springframework.stereotype.Service)")
    public void beforeLogging10() {
        System.out.println("Before logging logged 10!!");
    }

    @Before("within(com.learning.annotations.Annotations.Aspects.AspectController)"
            +
            "|| @within(org.springframework.stereotype.Service)")
    public void beforeLogging11() {
        System.out.println("Before logging logged 11!!");
    }

    @Pointcut("execution(public * com.learning.annotations.Annotations.Aspects.AspectController.*())")
    public void customPointCut() {
        // do nothing here
    }

    @Before("customPointCut()")
    public void customPointCutBeforeMethod() {
        System.out.println("custom point cut");
    }

    @Around("customPointCut()")
    public Object aroundLogging(ProceedingJoinPoint jointPoint) throws Throwable {
        System.out.println("around logging with custom point cut: before");
        Object res = jointPoint.proceed(); // since my method results data
        System.out.println("around logging with custom point cut: after");
        return res;

    }
}
