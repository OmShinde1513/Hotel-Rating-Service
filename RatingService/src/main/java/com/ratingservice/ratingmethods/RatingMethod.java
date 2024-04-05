package com.ratingservice.ratingmethods;

import com.ratingservice.entities.Rating;

import java.util.List;

public interface RatingMethod {
    Rating createRating(Rating rating);
    Rating getRating(String Id);
    List<Rating> getRatingsByHotelId(String HotelId);
    List<Rating> getRatingsByUserId(String UserId);
    List<Rating> getAllRatings();
}
