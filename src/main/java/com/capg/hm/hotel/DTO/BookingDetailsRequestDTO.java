package com.capg.hm.hotel.DTO;

import java.util.Date;
import java.util.List;

public class BookingDetailsRequestDTO {
	private int booking_id;
	private int hotel_id;
	private List<Integer> roomNo;
	private String username;
	private Date booked_from;
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

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public List<Integer> getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(List<Integer> roomNo) {
		this.roomNo = roomNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public BookingDetailsRequestDTO(int booking_id, int hotel_id, List<Integer> roomNo, String username,
			Date booked_from, Date booked_to, int no_of_adults, int no_of_children, double totalAmount) {
		super();
		this.booking_id = booking_id;
		this.hotel_id = hotel_id;
		this.roomNo = roomNo;
		this.username = username;
		this.booked_from = booked_from;
		this.booked_to = booked_to;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.totalAmount = totalAmount;
	}

	public BookingDetailsRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingDetailsRequestDTO [booking_id=").append(booking_id).append(", hotel_id=")
				.append(hotel_id).append(", roomNo=").append(roomNo).append(", username=").append(username)
				.append(", booked_from=").append(booked_from).append(", booked_to=").append(booked_to)
				.append(", no_of_adults=").append(no_of_adults).append(", no_of_children=").append(no_of_children)
				.append(", totalAmount=").append(totalAmount).append("]");
		return builder.toString();
	}

	
}
