package com.capg.hm.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hm.hotel.DTO.PaymentDTO;
import com.capg.hm.hotel.entity.Payment;
import com.capg.hm.hotel.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService service;
	
	@PostMapping("/payment/addPayment")  //end point to add payment
	public Payment addPayment(@RequestBody Payment payment) {
		return service.addPayment(payment);
	}
	
	@GetMapping("/payment/getAllPayment")  //end point to get all payment
	public List<Payment> getAllPayment(){
		return service.getAllPayment();
	}
}
