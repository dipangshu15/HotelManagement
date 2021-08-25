package com.capg.hm.hotel.entity;

import javax.persistence.*;
import javax.transaction.Transaction;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@OneToOne(targetEntity = Transactions.class)
	private Transactions transaction;
	
	@ManyToOne(targetEntity = BookingDetails.class)
	private BookingDetails booking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public BookingDetails getBooking() {
		return booking;
	}

	public void setBooking(BookingDetails booking) {
		this.booking = booking;
	}

	public Payment(int id, Transactions transaction, BookingDetails booking) {
		super();
		this.id = id;
		this.transaction = transaction;
		this.booking = booking;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", transaction=" + transaction + ", booking=" + booking + "]";
	}
	
	
	
}
