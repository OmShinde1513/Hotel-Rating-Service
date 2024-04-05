package com.userservice.services;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.external.services.HotelService;
import com.userservice.repositories.UserRepository;
import com.userservice.servicemethods.UserServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceMethods {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelService hotelService;
    @Override
    public User getSingleUser(String id) {
        User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not Found With Given Credentials"));
//       Rating[] ratingList=restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getId(),Rating[].class);
//        List<Rating> ratings=Arrays.stream(ratingList).map((rating)->{
//            ResponseEntity<Hotel>hotel=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel=hotelService.getHotel(rating.getHotelId());
//            rating.setHotel(hotel);
//            return rating;
//        }).collect(Collectors.toList());
//       user.setRatings(ratings);
       return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        String id=UUID.randomUUID().toString();
        user.setId(id);
        return userRepository.save(user);

    }

    @Override
    public User updateUser(String id,User user1) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User With Given Id Does Not Found"));
        user.setName(user1.getName());
        user.setAbout(user1.getAbout());
        user.setEmail(user1.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
       userRepository.deleteById(id);
    }
}
