package com.capg.hm.hotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hm.hotel.entity.Room;

@Repository
public interface roomRepository extends JpaRepository<Room,Integer>{
	public List<Optional<Room>> findByRoomType(String roomType);
	//public List<Room> findByHotel(int Hotel);
}
