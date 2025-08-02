package com.example.menumaker.core.utilities.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleUsernameAlreadyExists(DataIntegrityViolationException dataIntegrityViolationException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dataIntegrityViolationException.getMessage());
    }


}
