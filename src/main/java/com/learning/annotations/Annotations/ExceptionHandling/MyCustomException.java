package com.learning.annotations.Annotations.ExceptionHandling;

import com.learning.annotations.Annotations.Interceptors.MyCustomAnnotation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason = "My choice if it is invalid")
public class MyCustomException extends RuntimeException{
    HttpStatus status;
    MyCustomException(HttpStatus status, String message){
        super(message);
        this.status=status;
    }
}
