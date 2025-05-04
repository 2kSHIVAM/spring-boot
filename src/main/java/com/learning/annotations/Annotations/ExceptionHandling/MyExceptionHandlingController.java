package com.learning.annotations.Annotations.ExceptionHandling;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class MyExceptionHandlingController {

    @GetMapping("/getUserTryCatch")
    public ResponseEntity<?> getUserTryCatch(){
        try{
            throw new MyCustomException(HttpStatus.BAD_GATEWAY, "This occurred due to bad gateway");
        } catch(IllegalArgumentException ex) {
            ErrorResponse errorResponse=new ErrorResponse(new Date(), "This is illegal argument TRY CATCH", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (MyCustomException ex) {
            ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(){
        throw new IllegalArgumentException("inappropriate parameters are passed");
    }

    @GetMapping("/getUserCustom")
    public ResponseEntity<?> getUserCustom() {
        throw new MyCustomException(HttpStatus.BAD_REQUEST, "this is custom exception");
    }

//    @ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason = "My choice if it is invalid")
//    @ExceptionHandler(MyCustomException.class)
//    public ResponseEntity<String> myCustomExceptionHandler(MyCustomException ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }

//    @ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason = "My choice if it is invalid")
//    @ExceptionHandler(MyCustomException.class)
//    public void myCustomExceptionHandler(HttpServletResponse response, MyCustomException ex) throws IOException {
////        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage()+", wow"); // NOTE: if using reponseStatus as well make sure, body of method is empty to make sure it does not cause any issue
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> IllegalArgumentHandler(IllegalArgumentException ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler({MyCustomException.class, IllegalArgumentException.class})
//    public ResponseEntity<String> commonExceptionHandler(Exception ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
