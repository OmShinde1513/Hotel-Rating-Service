package com.ratingservice.exceptions;

public class RatingNotFoundException extends RuntimeException{
    public RatingNotFoundException(){
        super("Rating with corresponding RatingId Not found");

    }
    public RatingNotFoundException(String message)
    {
        super(message);
    }
}
