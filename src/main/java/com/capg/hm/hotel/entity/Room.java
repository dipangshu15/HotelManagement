package com.capg.hm.hotel.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;



@Entity
public class Room {

	@Id
	private int roomNo;

	@NotEmpty(message="room type cannot be blank")
	private String roomType; // Category delux
	
	//@NotEmpty(message="rate per day cannot be blank")
	private double ratePerDay;

	private Blob photo;

	public Room(int roomNo, String roomType, double ratePerDay, Blob photo) {
		super();

		//this.hotel = hotel;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;

		this.photo = photo;
		// this.noOfRooms = noOfRooms;
	}

	public Room() {
		super();
	}

	//public int getHotel() {
		//return hotel;
	//}

	//public void setHotel(int hotel) {
		//this.hotel = hotel;
	//}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + ", roomNo=" + roomNo + ", roomType=" + roomType + ", ratePerDay=" + ratePerDay
				+ ", isAvailable=" + ", photo=" + photo + ", noOfRooms=" + "]";
	}

}
