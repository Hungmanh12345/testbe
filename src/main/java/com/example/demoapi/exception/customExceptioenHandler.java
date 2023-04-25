package com.example.demoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class customExceptioenHandler {
    @ExceptionHandler(notFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public errorResponse handlerNotfoundException(notFountException ex, WebRequest req){
        return new errorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
