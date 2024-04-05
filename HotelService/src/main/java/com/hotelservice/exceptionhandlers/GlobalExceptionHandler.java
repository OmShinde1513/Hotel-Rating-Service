package com.hotelservice.exceptionhandlers;

import com.hotelservice.exceptions.ResourceNotFoundException;
import com.hotelservice.responseentities.NotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<NotFoundResponse>ResourceNotFoundExceptionHandler(ResourceNotFoundException e)
    {
     return ResponseEntity.ok(NotFoundResponse.builder().message(e.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build());
    }
}
