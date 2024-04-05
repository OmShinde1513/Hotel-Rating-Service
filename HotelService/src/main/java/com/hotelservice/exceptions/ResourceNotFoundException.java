package com.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException()
    {
        super("Hotel Not Found!!");
    }
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
