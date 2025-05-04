package com.learning.annotations.Annotations.ExceptionHandling;

import org.springframework.boot.autoconfigure.batch.BatchTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandling {

    //NOTE: IF THE CONTROLLER ITSELF HAS THE EXCEPTION HANDLER FOR SPECIFIC EXCEPTION THEN THAT WOULD RUN INSTEAD OF THE GLOBAL ONE
//    @ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason = "My choice if it is invalid")
    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<?> globalExceptionHandlerCustom(MyCustomException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> globalExceptionHandlerIllegalArgument(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
