package com.learning.annotations.Annotations.ExceptionHandling;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {
    @JsonProperty("creation_time")
    Date date;

    String message;

    public HttpStatus status;

    ErrorResponse(Date date, String message, HttpStatus status) {
        this.date=date;
        this.message=message;
        this.status=status;
    }

    //NOTE: EITHER MAKE THE FIELD PUBLIC OR CREATE ITS PUBLIC GETTER, this helps jackson at time of serialization of the object.
    public String getMessage(){
        return this.message;
    }
}
