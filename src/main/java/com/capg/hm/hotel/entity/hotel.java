package com.capg.hm.hotel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class hotel {
	@Id
	private int hotel_id;

	@NotEmpty(message="please enter city")
	private String city;

	@NotEmpty(message="please enter hotel name")
	private String hotel_name;

	@NotEmpty(message="please enter address")
	private String address;

	@NotEmpty(message = " please enter description")
	private String description;

	@NotEmpty(message = "please enter email")
	private String email;

	@NotEmpty(message = "please enter phone1")
	private String phone1;

	@NotEmpty(message = "please enter phone2")
	private String phone2;

	@NotEmpty(message = "please enter website")
	private String website;
	
	@OneToMany(targetEntity = Room.class)
	private List<Room> rooms;

	

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public hotel(int hotel_id, String city, String hotel_name, String address, String description, String email,
			String phone1, String phone2, String website, List<Room> rooms) {
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

	
	

	public hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "hotel [hotel_id=" + hotel_id + ", city=" + city + ", hotel_name=" + hotel_name + ", address=" + address
				+ ", description=" + description + ", no_of_rooms="+ ", email=" + email + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", website=" + website + ", rooms=" + "]";
	}

}
