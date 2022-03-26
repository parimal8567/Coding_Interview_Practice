package com.booking.recruitment.hotel.repository;

import com.booking.recruitment.hotel.model.Hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	Optional<Hotel> findByIdAndDeleted(Long id, Boolean deleted);
	
	@Query(value= "select * from hotel where cityId =:cityId and deleted= false",nativeQuery = true)
	List<Hotel> serchHotels(@Param("cityId") long cityId);
}
