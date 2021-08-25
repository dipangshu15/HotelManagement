package com.capg.hm.hotel.DTO;

import java.util.List;

public class HotelDTO {
	private int hotel_id;
	private String city;
	private String hotel_name;
	private String address;
	private String description;
	private String email;
	private String phone1;
	private String phone2;
	private String website;
	private List<Integer> rooms;
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<Integer> getRooms() {
		return rooms;
	}
	public void setRooms(List<Integer> rooms) {
		this.rooms = rooms;
	}
	public HotelDTO(int hotel_id, String city, String hotel_name, String address, String description, String email,
			String phone1, String phone2, String website, List<Integer> rooms) {
		super();
		this.hotel_id = hotel_id;
		this.city = city;
		this.hotel_name = hotel_name;
		this.address = address;
		this.description = description;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.rooms = rooms;
	}
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
