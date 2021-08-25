package com.capg.hm.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hm.hotel.entity.Room;
import com.capg.hm.hotel.exception.AdminPermissionRequired;
import com.capg.hm.hotel.exception.RoomNotFoundException;
import com.capg.hm.hotel.exception.RoomTypeNotFoundException;
import com.capg.hm.hotel.exception.UserNotLoggedIn;
import com.capg.hm.hotel.repository.roomRepository;

@Service
public class roomService {
	
	static  List<Double> rateByDay=new ArrayList<>();
	@Autowired
	private roomRepository roomRepository;
	
	//method to add new room
	public Room addRoom(Room room) {
		if(userService.adminLogIn) {
			return roomRepository.save(room);
		}
		else {
			throw new AdminPermissionRequired("admin permission required!!");
		}
	}
	
	//method to remove room by id
	public String removeRoomById(int roomNo){
		
		if(userService.adminLogIn) {
			Optional<Room> room = roomRepository.findById(roomNo);
			if (!room.isPresent()) {
				throw new RoomNotFoundException("room not present!!Cannot delete");
			} else {
				roomRepository.delete(room.get());
				return "deleted successfully";
			}

		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}
		
	}
	
	//method to get room by id
	public Room getById(int roomNo){
		if(userService.adminLogIn || userService.loggedIn) {
			Optional<Room> room = roomRepository.findById(roomNo);
			if (!room.isPresent()) {
				throw new RoomNotFoundException("Room is unavailable");
			}
			return room.get();
		}
		else {
			throw new UserNotLoggedIn("you are not logged in!!");
		}
	}
	
	//method to show all rooms
	public List<Room> showAllRoom() {
		
		if(userService.adminLogIn|| userService.loggedIn) {
			List<Room> list = new ArrayList<>();
			roomRepository.findAll().forEach(list::add);
			return list;

		}
		else {
			throw new UserNotLoggedIn("you are not logged in!!");
		}

	}

	//method to get room by type
	public List<Room> getByRoomType(String roomType){
		if(userService.adminLogIn||userService.loggedIn) {
			List<Optional<Room>> room=new ArrayList<>();
			room=roomRepository.findByRoomType(roomType);
			if (room.size()==0) {
				throw new RoomTypeNotFoundException("Room type not available");
			} else {
				List<Room> newRoom=new ArrayList<Room>();
				for(Optional r:room) {
					newRoom.add((Room) r.get());
				}
				return newRoom;
			}
		}
		else {
			throw new UserNotLoggedIn("you are not logged in!!");
		}
		
	}

	//method to update room
	public Room updateRoom(int roomNo, Room room) {
		if(userService.adminLogIn) {
			Optional<Room> result = roomRepository.findById(roomNo);
			if(result.isPresent()) {
				Room newResult=result.get();
				if (Objects.nonNull(room.getRoomType())) {
					newResult.setRoomType(room.getRoomType());
				}
				else if(Objects.nonNull(room.getRatePerDay())) {
					newResult.setRatePerDay(room.getRatePerDay());
				}
				

				//newResult.setRoomNo(roomNo);
				//result.setHotel(room.getHotel());
				
				
				roomRepository.save(newResult);

				return newResult;
			}
			
			else {
				throw new RoomNotFoundException("room does not exist with this id!!");
			}
		}
			
		else {
			throw new AdminPermissionRequired("admin permission is required!!!");
		}
	}


	
	
	
	

}
