package com.ratingservice.controllers;

import com.ratingservice.entities.Rating;
import com.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return ResponseEntity.ok(ratingService.createRating(rating));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable String id)
    {
        return ResponseEntity.ok(ratingService.getRating(id));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }
    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String id)
    {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(id));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String id)
    {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(id));
    }
}
