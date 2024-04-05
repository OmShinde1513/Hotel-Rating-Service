package com.hotelservice.feignclient;

import com.hotelservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingService {
    @GetMapping("/rating/hotel/{id}")
    List<Rating> getRating(@PathVariable("id") String hotelId);
}
