package com.booking.recruitment.hotel.service.impl;

import com.booking.recruitment.hotel.exception.BadRequestException;
import com.booking.recruitment.hotel.exception.ElementNotFoundException;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.recruitment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class DefaultHotelService implements HotelService {
  private final HotelRepository hotelRepository;

  @Autowired
  DefaultHotelService(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @Override
  public List<Hotel> getAllHotels() {
    return hotelRepository.findAll();
  }

  @Override
  public List<Hotel> getHotelsByCity(Long cityId) {
    return hotelRepository.findAll().stream()
        .filter((hotel) -> cityId.equals(hotel.getCity().getId()))
        .collect(Collectors.toList());
  }

  @Override
  public Hotel createNewHotel(Hotel hotel) {
    if (hotel.getId() != null) {
      throw new BadRequestException("The ID must not be provided when creating a new Hotel");
    }

    return hotelRepository.save(hotel);
  }

@Override
public Optional<Hotel> getHotelById(Long hotelId) {
	
	if (hotelId == null) {
	      throw new BadRequestException("The ID must be provided");
	 }
	return hotelRepository.findByIdAndDeleted(hotelId,false);
}

@Override
public void updateHotelbyId(Long id) {
	
	if (id == null) {
	      throw new BadRequestException("The ID must be provided");
	 }
	
	Optional<Hotel> hotel=hotelRepository.findById(id);
	if(hotel.isPresent()) {
		Hotel hotelEntity=hotel.get();
		hotelEntity.setDeleted(true);
		hotelRepository.save(hotelEntity);		
	}
	
	throw new ElementNotFoundException("Could not find the hotel with id-"+id);
}

@Override
public List<Hotel> searchHotels(Long cityId, String sortBy) {
	// TODO Auto-generated method stub
	return null;
}
}
