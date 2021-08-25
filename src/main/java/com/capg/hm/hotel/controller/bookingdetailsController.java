package com.capg.hm.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hm.hotel.DTO.BookingDetailsRequestDTO;
import com.capg.hm.hotel.entity.BookingDetails;
import com.capg.hm.hotel.service.bookingdetailsService;

@RestController
public class bookingdetailsController {
	@Autowired
	private bookingdetailsService bookingserviceimpl;
	
		// add booking details
		@PostMapping("/bookingdetails/addbookingdetails")
		public BookingDetails addBookingDetails(@Valid @RequestBody BookingDetailsRequestDTO bookingdetails) {
			return bookingserviceimpl.addBookingDetails(bookingdetails);
		}

		// update booking details with new bookingdetails object
		@PutMapping("/bookingdetails/updatebookingdetails/{id}")
		public BookingDetails updateBookingDetails(@PathVariable("id") int booking_id,
				@RequestBody BookingDetailsRequestDTO bookingdetails) {
			return bookingserviceimpl.updateBookingDetails(booking_id, bookingdetails);
		}

		// delete booking details by booking id
		@DeleteMapping("/bookingdetails/deletebookingdetails/{id}")
		public String deleteBookingDetailsById(@PathVariable("id") int booking_id) {
			bookingserviceimpl.deleteBookingDetailsById(booking_id);
			return "booking details with [ " + booking_id + " ] deleted successfully !";
		}

		// show all booking details
		@GetMapping(value = "/bookingdetails/fetchallbookingdetails", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<BookingDetails> fetchAllBookingDetails() {
			List<BookingDetails> listBookingDetails = new ArrayList<>();
			listBookingDetails = bookingserviceimpl.fetchAllBookingDetails();
			return listBookingDetails;
		}

		// @ExceptionHandler(BookingNotFoundException.class)
		// find details by booking id
		@GetMapping(value = "/bookingdetails/bookingdetails/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public BookingDetails fetchBookingDetailsById(@PathVariable("id") int booking_id) {
			BookingDetails result = bookingserviceimpl.fetchBookingDetailsById(booking_id);
			return result;
		}

		
	
}
