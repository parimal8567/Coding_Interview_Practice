package com.booking.recruitment.hotel.service;

import java.util.List;

import com.booking.recruitment.hotel.model.Hotel;

public interface HotelSearchService {

	
	List<Hotel> searchHotels(Long cityId, String sortBy);
}
