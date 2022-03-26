package com.booking.recruitment.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.recruitment.hotel.exception.BadRequestException;
import com.booking.recruitment.hotel.exception.ElementNotFoundException;
import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.repository.CityRepository;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.recruitment.hotel.service.HotelSearchService;

@Service
public class DefaultHotelSearchService implements HotelSearchService{

	private final HotelRepository hotelRepository;
	private final CityRepository cityRepository;
	
	@Autowired
	DefaultHotelSearchService(HotelRepository hotelRepository,CityRepository cityRepository) {
	    this.hotelRepository = hotelRepository;
	    this.cityRepository= cityRepository;
	  }
	
	@Override
	public List<Hotel> searchHotels(Long cityId, String sortBy) {
		
		
		Optional<City> city=cityRepository.findById(cityId);
		if(!city.isPresent()) {
			throw new BadRequestException("Incorrect cityId provided");
		}
		
		List<Hotel> hotels=hotelRepository.serchHotels(cityId);
		if(hotels.isEmpty()) {
			throw new ElementNotFoundException("No Hotels found in the given city!");
		}
		
		
		hotels.stream().forEach(hotel-> {
			double lat=hotel.getLatitude();
			double log=hotel.getLongitude();
			double cityLat=city.get().getCityCentreLatitude();
			double cityLog=city.get().getCityCentreLongitude();
		}
		
		
		
	}

}
