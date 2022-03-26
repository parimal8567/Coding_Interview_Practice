package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.exception.ElementNotFoundException;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Hotel> getAllHotels() {
    return hotelService.getAllHotels();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Hotel createHotel(@RequestBody Hotel hotel) {
    return hotelService.createNewHotel(hotel);
  }
  
  @GetMapping(value="/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Hotel getHotelById(@PathVariable Long id){
	  
	  Optional<Hotel> hotel=hotelService.getHotelById(id);
	  if(hotel.isPresent()) {
		  return hotel.get();
	  }
	throw new ElementNotFoundException("Hotel with Id -"+id+" is not present.");
  }
  
  @PutMapping(value="/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteHotel(@PathVariable Long id) {
	  hotelService.updateHotelbyId(id);
  }
}
