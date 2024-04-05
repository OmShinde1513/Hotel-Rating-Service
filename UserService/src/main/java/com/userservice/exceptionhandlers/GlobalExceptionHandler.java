package com.userservice.exceptionhandlers;

import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.responseentities.EResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<EResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e)
    {
        EResponse response= EResponse.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
