package com.learning.annotations.Annotations.Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api")
public class MyAsyncTestController {

    @Autowired
    UserService userService;

    @GetMapping("/fetchUserDetails")
    public void fetchUserDetails(){
        System.out.println("Fetching user details");
        System.out.println("Main thread: "+Thread.currentThread().getName());
        userService.testAsync();
    }

    @GetMapping("/testAsync")
    public void testAsync(){
        System.out.println("Fetching user details");
        System.out.println("Main thread: "+Thread.currentThread().getName());
        Future<String> output = userService.testAsyncFutureDeprecated();
        try{
            System.out.println(output.get());
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @GetMapping("/testAsync2")
    public void testAsync2(){
        System.out.println("Fetching user details");
        System.out.println("Main thread: "+Thread.currentThread().getName());
        CompletableFuture<String> output = userService.testAsyncCompletableFuture();
        try{
            System.out.println(output.get());
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @GetMapping("/testAsync3")
    public void testAsync3(){
        System.out.println("Fetching user detailss");
        System.out.println("Main thread: "+Thread.currentThread().getName());
        userService.testAsyncUncaughtExceptionHandling();
    }
}
