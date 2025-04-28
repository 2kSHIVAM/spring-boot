package com.learning.annotations.Annotations.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class UserService {

    @Async()
    public void testAsync(){
        System.out.println("This is async thread: "+Thread.currentThread().getName());
        try{
            Thread.sleep(50000);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Async
    public Future<String> testAsyncFutureDeprecated(){
        System.out.println("This is async thread: "+Thread.currentThread().getName());
        return new AsyncResult<>("Returned from async function");
    }

    @Async
    public CompletableFuture<String> testAsyncCompletableFuture(){
        System.out.println("This is async thread: "+Thread.currentThread().getName());
        // first way to handle exception
        try{
            System.out.println(3/0);
        }catch (Exception e){
            System.out.println(e+", shit!");
        }
        return CompletableFuture.completedFuture("Returned from async function");
    }

    @Async
    public void testAsyncUncaughtExceptionHandling(){
        System.out.println("This is async thread: "+Thread.currentThread().getName());
        // first way to handle exception
        System.out.println(3/0);
        System.out.println("Hi there");
    }
}
