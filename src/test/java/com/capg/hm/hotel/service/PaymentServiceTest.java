package com.capg.hm.hotel.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.hm.hotel.DTO.PaymentDTO;
import com.capg.hm.hotel.entity.Payment;
import com.capg.hm.hotel.repository.paymentRepository;

@SpringBootTest
class PaymentServiceTest {
	@Autowired
	private PaymentService pay;
	@MockBean
	private paymentRepository payrepo;
	
	Payment payment;
	PaymentDTO paydto;
	
	@BeforeEach
	void setUp() throws Exception {
		com.capg.hm.hotel.service.userService.setAdminLogIn(true);
		com.capg.hm.hotel.service.userService.setLoggedIn(true);
		
		payment=new Payment();
		payment.setId(12);
		payment.setBooking(null);
		payment.setTransaction(null);
		
		paydto=new PaymentDTO();
		
		paydto.setBooking_id(34);
		paydto.setId(12);
		paydto.setTransaction_id(9);
		
		//payment = Payment.builder().id(12).booking(null).transaction(null).build();
		//paydto=PaymentDTO.builder().id(12).booking_id(34).transaction_id(9).build();
		List<Payment> list = new ArrayList<Payment>(){ {add(payment);}};

				Mockito.when(payrepo.save(payment)).thenReturn(payment);
				Mockito.when(payrepo.findAll()).thenReturn(list);
	}

	   @Test
	   @DisplayName("testing fetch all payment")
	   void getAllPaymentTest() {
	   List<Payment> list = new ArrayList<Payment>(){ {add(payment);}};
	   assertEquals(list,pay.getAllPayment()); }

}
