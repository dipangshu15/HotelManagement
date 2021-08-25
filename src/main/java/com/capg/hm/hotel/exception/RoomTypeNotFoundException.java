package com.capg.hm.hotel.exception;

public class RoomTypeNotFoundException extends RuntimeException{
	//private static final long serialVersionUID = 1L;

	public RoomTypeNotFoundException(String message) {
		super(message);
	}
}
