package com.capg.hm.hotel.DTO;

public class PaymentDTO {
	private int id;
	private int transaction_id;
	private int booking_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public PaymentDTO(int id, int transaction_id, int booking_id) {
		super();
		this.id = id;
		this.transaction_id = transaction_id;
		this.booking_id = booking_id;
	}
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", transaction_id=" + transaction_id + ", booking_id=" + booking_id + "]";
	}
	
}
