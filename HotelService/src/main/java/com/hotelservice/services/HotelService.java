package com.hotelservice.services;

import com.hotelservice.entities.Hotel;
import com.hotelservice.entities.Rating;
import com.hotelservice.exceptions.ResourceNotFoundException;
import com.hotelservice.feignclient.RatingService;
import com.hotelservice.feignclient.UserService;
import com.hotelservice.repositories.HotelRepository;
import com.hotelservice.servicemethods.HotelMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelService implements HotelMethods {
    @Autowired
    RatingService ratingService;
    @Autowired
    UserService userService;
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel getHotel(String id) {
        Hotel hotel= hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel With given Id Not Found"));
       List<Rating> ratingList=ratingService.getRating(id);
       List<Rating> list=ratingList.stream().map(rating ->{
           rating.setUser(userService.getUser(rating.getUserId()));
           return rating;
       }).toList();
       hotel.setRatingList(list);
       return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(String id, Hotel hotel) {
        Hotel h=hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not Updated"));
        h.setName(hotel.getName());
        h.setAbout(hotel.getAbout());
        h.setLocation(hotel.getLocation());
        return hotelRepository.save(h);
    }

    @Override
    public void deleteHotel(String id) {
       hotelRepository.deleteById(id);
    }
}
