package com.capg.hm.hotel.exception;

public class AdminPermissionRequired extends RuntimeException{
	public AdminPermissionRequired(String message) {
		super(message);
	}
}
