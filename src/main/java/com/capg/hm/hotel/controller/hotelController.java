package com.capg.hm.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hm.hotel.DTO.HotelDTO;
import com.capg.hm.hotel.entity.hotel;
import com.capg.hm.hotel.exception.HotelNotFoundException;
import com.capg.hm.hotel.service.hotelService;


@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class hotelController {
	@Autowired
	private hotelService service;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getAllHotels")  //end point to get all hotels
	public List<hotel> getAllHotels() {
		List<hotel> list=new ArrayList<>();
		list=service.getAllHotel();
		return list;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addHotel")  //end point to add hotel
	public hotel addHotel(@Valid @RequestBody HotelDTO hotel){
		//System.out.println(hotel);
		hotel h=service.addHotel(hotel);
		return h;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/findByCity")  //end point to find hotel by city
	public List<hotel> getByCity(@RequestBody hotel hotel){
		List<hotel> result=service.getByCity(hotel.getCity());
		return result;
	}
	
	@PutMapping("/updateHotel/{id}")  //end point to update hotel
	public hotel updateHotel(@PathVariable("id") int hotelId,@RequestBody HotelDTO hotel){
		return service.updateHotel(hotelId, hotel);
	}
	
	@DeleteMapping("/deleteHotel/{id}")  //end point to delete hotel
	public String deletHotel(@PathVariable("id") int hotelId) throws HotelNotFoundException{
		service.deleteHotel(hotelId);
		return "hotel with id "+ hotelId +" is deleted";
	}
	
	//@CrossOrigin("http://localhost:4200")
	@GetMapping("/findById/{id}")  //end point to find hotel by id
	public hotel getById(@PathVariable("id") int id){
		return service.getById(id);
	}
	
}
