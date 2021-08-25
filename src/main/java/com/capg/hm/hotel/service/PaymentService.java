package com.capg.hm.hotel.service;

import java.util.ArrayList;
import java.util.List;

import com.capg.hm.hotel.entity.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hm.hotel.entity.Payment;
import com.capg.hm.hotel.entity.Transactions;
import com.capg.hm.hotel.exception.AdminPermissionRequired;
import com.capg.hm.hotel.exception.UserNotLoggedIn;
import com.capg.hm.hotel.repository.bookingdetailsRepository;
import com.capg.hm.hotel.repository.paymentRepository;
import com.capg.hm.hotel.repository.TransactionRepository;

@Service
public class PaymentService implements PaymentServiceInterface{
	@Autowired
	private paymentRepository paymentRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private bookingdetailsRepository bookingdetailsRepository;
	@Autowired
	private userService userServiceForLogin;
	
	//method to add new payment
	public Payment addPayment(Payment payment) {
		if(userServiceForLogin.adminLogIn||userServiceForLogin.loggedIn) {
			Transactions transaction = transactionRepository.findById(payment.getTransaction().getTransaction_id()).get();
			BookingDetails bookingDetails = bookingdetailsRepository.findById(payment.getBooking().getBooking_id()).get();
			Payment newPayment = new Payment();
			newPayment.setTransaction(transaction);
			newPayment.setBooking(bookingDetails);
			return paymentRepository.save(newPayment);
		}
		else {
			throw new UserNotLoggedIn("you are not logged in!!");
		}
		
	}
	
	//method to get all payment
	public List<Payment> getAllPayment(){
		if(userService.adminLogIn) {
			List<Payment> list=new ArrayList<Payment>();
			paymentRepository.findAll().forEach(list::add);
			return list;
		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}
		
	}
}
