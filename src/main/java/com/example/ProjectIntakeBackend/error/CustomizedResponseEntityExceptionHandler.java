package com.example.ProjectIntakeBackend.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController		//because it is providing a exception response
@ControllerAdvice//WE USE this when we wanna share some code between classes.
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)	//handles all the exception
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)	//we want to instantiate a bean everytime an exception happens
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(RequestNotFoundException.class)
    public final ResponseEntity<Object> handleRequestNotFoundException(RequestNotFoundException ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Request Not Found", request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    //if the client sends an invalid request then this method will be executed and the message will be displayed
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
//    {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation failed", ex.getBindingResult().toString());
//        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
//    }
}
