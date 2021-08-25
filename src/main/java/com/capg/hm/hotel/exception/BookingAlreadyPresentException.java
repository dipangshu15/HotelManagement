package com.capg.hm.hotel.exception;

public class BookingAlreadyPresentException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BookingAlreadyPresentException(String s) {
		super(s);
	}
}
