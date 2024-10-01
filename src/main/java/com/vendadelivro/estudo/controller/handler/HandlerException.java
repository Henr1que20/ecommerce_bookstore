package com.vendadelivro.estudo.controller.handler;

import com.vendadelivro.estudo.service.exception.EmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorMessage> handlerNotFoundException(EmailException ex) {
        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), ex.getMessage(), "Bad request");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}

