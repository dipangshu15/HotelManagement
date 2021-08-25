package com.capg.hm.hotel.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.hm.hotel.DTO.HotelDTO;
import com.capg.hm.hotel.entity.Room;
import com.capg.hm.hotel.entity.hotel;
import com.capg.hm.hotel.exception.HotelNotFoundException;
import com.capg.hm.hotel.repository.hotelRepository;

@SpringBootTest
class HotelServiceTest {
	
	
	@Autowired
	private hotelService service;
	@MockBean
	private hotelRepository repo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		com.capg.hm.hotel.service.userService.setAdminLogIn(true);
		com.capg.hm.hotel.service.userService.setLoggedIn(true);
		
		Room r=new Room();
		r.setRatePerDay(2000.00);
		r.setRoomNo(1);
		r.setRoomType("deluxe");
		
		List<Room> rooms=new ArrayList<>();
		rooms.add(r);
		
		hotel h=new hotel();
		h.setHotel_id(4);
		h.setAddress("somewhere in chennai");
		h.setCity("chennai");
		h.setDescription("short desc");
		h.setEmail("abc.gmail.com");
		h.setHotel_name("grand");
		h.setPhone1("111");
		h.setPhone2("222");
		h.setWebsite("abc.com");
		h.setRooms(rooms);
		
		List<hotel> list=new ArrayList<>();
		list.add(h);
		
		Mockito.when(repo.findById(4)).thenReturn(Optional.of(h));
		Mockito.when(repo.findByCity("chennai")).thenReturn(list);
		Mockito.when(repo.findAll()).thenReturn(list);
		Mockito.when(repo.save(h)).thenReturn(h);
		Mockito.when(repo.save(h)).thenReturn(h);
		
	}

	@Test
	void getById() {
		
		
		
		
		hotel Hotel=service.getById(4);
		
		assertEquals(Hotel.getHotel_id(),4);
		
	}
	
	
	@Test
	void addHotel() {
		List<Integer> rooms=new ArrayList<>();
		Room room=new Room();
		room.setRoomType("deluxe");
		room.setRoomNo(1);
		room.setRatePerDay(1200.45);
		rooms.add(1);
		
		HotelDTO h=new HotelDTO();
		
		
		h.setHotel_id(4);
		h.setAddress("somewhere in chennai");
		h.setCity("chennai");
		h.setDescription("short desc");
		h.setEmail("abc.gmail.com");
		h.setHotel_name("grand");
		h.setPhone1("111");
		h.setPhone2("222");
		h.setWebsite("abc.com");
		h.setRooms(rooms);

		
		hotel newhotel=service.addHotel(h);
		
		assertEquals(h.getHotel_id(),newhotel.getHotel_id());
	}
	
	@Test
	void getAllHotels() {
		
		List<hotel> hotels=service.getAllHotel();
		
		assertNotEquals(hotels.size(),0);
	}
	
	@Test
	void updateHotelTest() {
		HotelDTO hotel=new HotelDTO();
		hotel.setHotel_id(4);
		hotel.setPhone1("44444444");
		hotel h=service.updateHotel(4,hotel);
		
		assertEquals(h.getHotel_id(),4);
	}
	
	@Test
	void getHotelByCityTest() {
		String city="chennai";
		
		List<hotel> list=service.getByCity(city);
		
		assertEquals(city,list.get(0).getCity());
	}
}
