package com.userservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException()
    {
        super("User Not Found !!");
    }
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

}
