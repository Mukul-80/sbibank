package com.microservice.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(UsernameNotFoundException ex) {

        return ResponseEntity
              .status(HttpStatus.BAD_REQUEST)
              .body(ex.getMessage());
    }
}
