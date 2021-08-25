package com.capg.hm.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hm.hotel.entity.Room;
import com.capg.hm.hotel.service.roomService;

@RestController
public class roomController {
	@Autowired
	private roomService roomService;
	
	@PostMapping("/room/addRoom")  //end point to add room
	public Room addRoom(@Valid @RequestBody Room room) {
		roomService.addRoom(room);
		return room;
	}

	@GetMapping("/room/getAllRoom")  //end point to get all room
	public List<Room> showAllRoom() {
		List<Room> list = new ArrayList<>();
		list = roomService.showAllRoom();
		return list;
	}

	@DeleteMapping("/room/deleteRoom/{id}")  //end point to delete room id
	public String removeRoom(@PathVariable("id") int id) {
		return roomService.removeRoomById(id);
		//System.out.println("deleted successfully");
		 //"RoomNo-"+id+"deleted successfully";
	}

	@GetMapping("/room/findByRoomType/{single}")  //end point to find room by type
	public List<Room> getByRoomType(@PathVariable("single") String str) {
		List<Room> result=new ArrayList<>();
		result = roomService.getByRoomType(str);
		return result;
	}

	@GetMapping("/room/getRoomById/{id}")  //end point to get room by id
	public Room showRoomById(@PathVariable("id") int id) {
		Room result = roomService.getById(id);
		return result;

	}

	
	  @PutMapping("/room/updateRoom/{id}") 
	  public Room updateRoom(@PathVariable("id")int id, @RequestBody Room room) {
	  
	  Room result = roomService.updateRoom(id, room);
	  
	  return result; }
	 

	  
	  //@GetMapping("/room/selectRoomById/{id}")
	  //public List<Room> selectRoom(@PathVariable("id") List<Integer> id){
		  //List<Room> rooms=new ArrayList<>();
		  //rooms=roomService.selectRoom(id);
		  //return rooms;
	  //}

}
