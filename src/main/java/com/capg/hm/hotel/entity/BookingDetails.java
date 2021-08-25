package com.capg.hm.hotel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class BookingDetails {
	
	@Id
	private int booking_id;
	
	@OneToOne(targetEntity = hotel.class)
	private hotel hotel_id; 
	
		
	@OneToMany(targetEntity = Room.class)
	private List<Room> roomNo;
		
	@OneToOne(targetEntity = Users.class)
	private Users userName;
	
	@Temporal(TemporalType.DATE)
	private Date booked_from;

	@Temporal(TemporalType.DATE)
	private Date booked_to;
	
	private int no_of_adults;
	
	private int no_of_children;
	
	private double totalAmount;

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public hotel getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(hotel hotel_id) {
		this.hotel_id = hotel_id;
	}

	public List<Room> getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(List<Room> roomNo) {
		this.roomNo = roomNo;
	}

	public Users getUsername() {
		return userName;
	}

	public void setUsername(Users username) {
		this.userName = username;
	}

	public Date getBooked_from() {
		return booked_from;
	}

	public void setBooked_from(Date booked_from) {
		this.booked_from = booked_from;
	}

	public Date getBooked_to() {
		return booked_to;
	}

	public void setBooked_to(Date booked_to) {
		this.booked_to = booked_to;
	}

	public int getNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(int no_of_adults) {
		this.no_of_adults = no_of_adults;
	}

	public int getNo_of_children() {
		return no_of_children;
	}

	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BookingDetails(int booking_id, hotel hotel_id, List<Room> roomNo, Users username, Date booked_from, Date booked_to,
			int no_of_adults, int no_of_children, double totalAmount) {
		super();
		this.booking_id = booking_id;
		this.hotel_id = hotel_id;
		this.roomNo = roomNo;
		this.userName = username;
		this.booked_from = booked_from;
		this.booked_to = booked_to;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.totalAmount = totalAmount;
	}

	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", hotel_id=" + hotel_id + ", roomNo=" + roomNo
				+ ", username=" + userName + ", booked_from=" + booked_from + ", booked_to=" + booked_to
				+ ", no_of_adults=" + no_of_adults + ", no_of_children=" + no_of_children + ", totalAmount="
				+ totalAmount + "]";
	}	
	
}

