package com.example.demo.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.demo.exception.customerException;

@ControllerAdvice
public class customerNotfoundAdvice {
    // what this does is that we want this advice to response only when the customerException occurs
    @ResponseBody
    @ExceptionHandler(customerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String customerNotFoundHandler(customerException exception) {
        return exception.getMessage();
    }
}
