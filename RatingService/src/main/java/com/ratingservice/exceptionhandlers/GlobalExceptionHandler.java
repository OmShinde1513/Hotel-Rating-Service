package com.ratingservice.exceptionhandlers;

import com.ratingservice.exceptions.RatingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<Map<String,Object>> RatingNotFoundExceptionHandler(RatingNotFoundException e)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("success",true);
        map.put("message",e.getMessage());
        return ResponseEntity.ok(map);
    }
}
