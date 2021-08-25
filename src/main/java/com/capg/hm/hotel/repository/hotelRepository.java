package com.capg.hm.hotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hm.hotel.entity.hotel;

@Repository
public interface hotelRepository extends JpaRepository<hotel,Integer>{
	
	public List<hotel> findByCity(String city);
}
