package com.booking.recruitment.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelSearchService;
import com.booking.recruitment.hotel.service.HotelService;

@RestController
@RequestMapping("search")
public class HotelSearch {
	
	  private final HotelSearchService hotelSearchService;

	  @Autowired
	  public HotelSearch(HotelSearchService hotelSearchService) {
	    this.hotelSearchService = hotelSearchService;
	  }
	
	@GetMapping(value="/{cityId}")
	@ResponseStatus
	public List<Hotel> findHotels(@PathVariable Long cityId, @RequestParam String sortBy ){
		
		List<Hotel> hotels=hotelSearchService.searchHotels(cityId, sortBy);  
		
		
		
		return hotels;
		
	} 
}
