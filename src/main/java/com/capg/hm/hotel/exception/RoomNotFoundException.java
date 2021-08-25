package com.capg.hm.hotel.exception;

public class RoomNotFoundException extends RuntimeException{
	//rivate static final long serialVersionUID = 1L;

	public RoomNotFoundException(String message) {
		super(message);
	}
}
