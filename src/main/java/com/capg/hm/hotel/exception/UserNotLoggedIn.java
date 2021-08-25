package com.capg.hm.hotel.exception;

public class UserNotLoggedIn extends RuntimeException{
	public UserNotLoggedIn(String message) {
		super(message);
	}
}
