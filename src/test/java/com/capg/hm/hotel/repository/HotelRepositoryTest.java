package com.capg.hm.hotel.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.capg.hm.hotel.entity.hotel;

@DataJpaTest
class HotelRepositoryTest {
	
	@Autowired
	private hotelRepository repo;
	
	//@Autowired
	//private TestEntityManager entityManager; 
	
	

	@BeforeEach
	void setUp() throws Exception {
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
		
		//entityManager.persist(h);
		repo.save(h);
	}

	@Test
	void test() {
		List<hotel> Hotel=repo.findByCity("chennai");
		
		assertEquals("chennai",Hotel.get(0).getCity());
	}

}
