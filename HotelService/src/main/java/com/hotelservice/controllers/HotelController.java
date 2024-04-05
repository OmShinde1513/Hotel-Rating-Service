package com.hotelservice.controllers;

import com.hotelservice.entities.Hotel;
import com.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id)
    {
        return ResponseEntity.ok(hotelService.getHotel(id));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id,@RequestBody Hotel hotel)
    {
        return ResponseEntity.ok(hotelService.updateHotel(id,hotel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable String id)
    {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }
}
