package com.ratingservice.services;

import com.ratingservice.RatingServiceApplication;
import com.ratingservice.entities.Rating;
import com.ratingservice.exceptions.RatingNotFoundException;
import com.ratingservice.ratingmethods.RatingMethod;
import com.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements RatingMethod {
    @Autowired
    RatingRepository ratingRepository;
    public Rating createRating(Rating rating)
    {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRating(String Id) {
        return ratingRepository.findById(Id).orElseThrow(()->new RatingNotFoundException("Rating with Corresponding RatingId not found"));
    }

    @Override
    public List<Rating> getRatingsByHotelId(String HotelId) {
        return ratingRepository.findAllByHotelId(HotelId);
    }

    @Override
    public List<Rating> getRatingsByUserId(String UserId) {
        return ratingRepository.findAllByUserId(UserId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
