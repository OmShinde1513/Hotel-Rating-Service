package com.hotelservice.servicemethods;

import com.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelMethods {
    Hotel getHotel(String id);
    List<Hotel> getAllHotels();
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(String id,Hotel hotel);
    void deleteHotel(String id);
}
