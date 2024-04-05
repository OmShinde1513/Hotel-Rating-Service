package com.userservice.external.services;

import com.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/{id}")
   Hotel getHotel(@PathVariable("id") String hotelId);
}
