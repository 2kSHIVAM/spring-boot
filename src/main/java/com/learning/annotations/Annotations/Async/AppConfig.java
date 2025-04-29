package com.learning.annotations.Annotations.Async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//@Configuration
//public class AppConfig {
//
//    // THREAD POOL TASK EXECUTOR CODE BELOW
//    @Bean(name="myCustomExecutor")
//    public Executor myCustomExecutor(){
//        int maxPoolSize=4;
//        int minPoolSize=2;
//        int queueSize=3;
//        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
//        poolTaskExecutor.setCorePoolSize(minPoolSize);
//        poolTaskExecutor.setMaxPoolSize(maxPoolSize);
//        poolTaskExecutor.setQueueCapacity(queueSize);
//        poolTaskExecutor.initialize();
//        return poolTaskExecutor;
//    }

    //THREAD POOL EXECUTOR USING JAVA
    //*************************************************************
    //NOTE in case we dont put the name i.e myCustomExecutor
    //in async, then out executor wont work and our thread will
    //be created of simpleAsyncTaskExecutor
    //*************************************************************


//    @Bean(name="myCustomExecutor")
//    public Executor myCustomExecutor(){
//        int minPoolSize = 2;
//        int maxPoolSize = 4;
//        int queueSize = 3;
//
//        return new ThreadPoolExecutor(minPoolSize,maxPoolSize,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(queueSize),new CustomThreadFactory());
//    }
//
//    class CustomThreadFactory implements ThreadFactory{
//        private final AtomicInteger threadNo = new AtomicInteger(0);
//        @Override
//        public Thread newThread(Runnable r){
//            Thread thread = new Thread(r);
//            thread.setName("My-thread-"+threadNo.getAndIncrement());
//            return thread;
//        }
//    }
//
//
//}


// WHEN WE DONT WANT ANY SORT OF CONFUSION AND JUST WANT TO USE OUR OWN CUSTOM JAVA THREAD POOL EXECUTOR WITHOUT WANTING TO ADD THE NAME OF BEAN EACH TIME IN ASYNC ANNOTATION

@Configuration
public class AppConfig implements AsyncConfigurer{
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler;

    @Override
    public synchronized Executor getAsyncExecutor(){
        if(threadPoolExecutor==null){
            int minPoolSize = 2;
            int maxPoolSize = 4;
            int queueSize = 3;
            threadPoolExecutor = new ThreadPoolExecutor(minPoolSize,maxPoolSize,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(queueSize),new CustomThreadFactory());
        }
        return threadPoolExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return this.asyncUncaughtExceptionHandler;
    }


    class CustomThreadFactory implements ThreadFactory{
        private final AtomicInteger threadNo = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r){
            Thread thread = new Thread(r);
            thread.setName("My-thread-"+threadNo.getAndIncrement());
            return thread;
        }
    }

}

@Component
class DefaultAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler{
    @Override
    public void handleUncaughtException(Throwable ex, Method m, Object... params){
        System.out.println("This is my custom exception handler");
    }
}
