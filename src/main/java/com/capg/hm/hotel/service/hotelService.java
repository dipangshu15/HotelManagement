package com.capg.hm.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hm.hotel.DTO.HotelDTO;
import com.capg.hm.hotel.entity.Room;
import com.capg.hm.hotel.entity.hotel;
import com.capg.hm.hotel.exception.AdminPermissionRequired;
import com.capg.hm.hotel.exception.HotelNotFoundException;
import com.capg.hm.hotel.exception.UserNotLoggedIn;
import com.capg.hm.hotel.repository.hotelRepository;
import com.capg.hm.hotel.repository.roomRepository;

import com.capg.hm.hotel.service.userService;

@Service
public class hotelService {
	@Autowired
	private hotelRepository repo;
	@Autowired
	private roomRepository roomRepo;
	
	//method to add new hotel
	
	public hotel addHotel(HotelDTO hotel) {
		if(userService.adminLogIn) {
			List<Room> rooms=new ArrayList<Room>();
			roomRepo.findAllById(hotel.getRooms()).forEach(rooms::add);
			hotel newHotel=new hotel();
			newHotel.setHotel_id(hotel.getHotel_id());
			newHotel.setCity(hotel.getCity());
			newHotel.setHotel_name(hotel.getHotel_name());
			newHotel.setAddress(hotel.getAddress());
			newHotel.setDescription(hotel.getDescription());
			newHotel.setEmail(hotel.getEmail());
			newHotel.setPhone1(hotel.getPhone1());
			newHotel.setPhone2(hotel.getPhone2());
			newHotel.setWebsite(hotel.getWebsite());
			newHotel.setRooms(rooms);
			repo.save(newHotel);
			return newHotel;
		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}
		
	}
	
	//method to get all hotel
	public List<hotel> getAllHotel(){
		if(userService.loggedIn==true || userService.adminLogIn==true) {
		List<hotel> list=new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
		}
		else {
			throw new UserNotLoggedIn("you are not logged in");
		}
	}
	
	//method to get hotel hotel by city
	public List<hotel> getByCity(String city){
		if(userService.loggedIn==true || userService.adminLogIn==true) {
			List<hotel> h=repo.findByCity(city);
			if(h.size()==0) {
				throw new HotelNotFoundException("no hotels near this city");
			}
			return repo.findByCity(city);
		}
		else {
			throw new UserNotLoggedIn("you are not logged in");
		}
		
	}
	
	//method to get hotel by id
	public hotel getById(int id){
		if(userService.loggedIn==true || userService.adminLogIn==true) {
			Optional<hotel> Hotel = repo.findById(id);
		    if(!Hotel.isPresent())
		    	{
		    	throw new HotelNotFoundException("hotel is not available");
		    		}
		    
		    return Hotel.get();
		}
		else {
			throw new UserNotLoggedIn("you are not logged in");
		}
		
	}
	
	//method to update hotel 
	public hotel updateHotel(int hotelId,HotelDTO hotel){
		if(userService.adminLogIn) {
			Optional<hotel> h=repo.findById(hotelId);
			if(!h.isPresent()) {
				throw new HotelNotFoundException("no hotel present by this id");
			}
			
			
			hotel result=h.get();
			if(Objects.nonNull(hotel.getHotel_id())&&hotel.getHotel_id()!=0) {
				result.setHotel_id(hotel.getHotel_id());
			}
			if(Objects.nonNull(hotel.getHotel_name())) {
				result.setHotel_name(hotel.getHotel_name());
			}
			if(Objects.nonNull(hotel.getEmail())) {
				result.setEmail(hotel.getEmail());
			}
			if(Objects.nonNull(hotel.getPhone1())) {
				result.setPhone1(hotel.getPhone1());
			}
			if(Objects.nonNull(hotel.getPhone2())) {
				result.setPhone2(hotel.getPhone2());
			}
			if(Objects.nonNull(hotel.getAddress())) {
				result.setAddress(hotel.getAddress());
			}
			if(Objects.nonNull(hotel.getCity())) {
				result.setCity(hotel.getCity());
			}
			if(Objects.nonNull(hotel.getDescription())) {
				result.setDescription(hotel.getDescription());
			}
			if(Objects.nonNull(hotel.getWebsite())) {
				result.setWebsite(hotel.getWebsite());
			}
			if(Objects.nonNull(hotel.getRooms())) {
				List<Room> rooms=new ArrayList<Room>();
				roomRepo.findAllById(hotel.getRooms()).forEach(rooms::add);
				result.setRooms(rooms);
			}
			
			repo.save(result);
			return result;
		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}
		
		
	}
	
	//method to delete hotel
	public void deleteHotel(int hotelId){
		if(userService.adminLogIn) {
			Optional<hotel> hotel=repo.findById(hotelId);
			if(!hotel.isPresent()) {
				throw new HotelNotFoundException("no hotel present with this id");
			}
			else repo.deleteById(hotelId);
		}
		else {
			throw new AdminPermissionRequired("admin permission is required");
		}
		
	}
}
