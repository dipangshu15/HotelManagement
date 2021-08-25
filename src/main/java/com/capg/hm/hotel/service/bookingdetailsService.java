package com.capg.hm.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hm.hotel.DTO.BookingDetailsRequestDTO;
import com.capg.hm.hotel.entity.BookingDetails;
import com.capg.hm.hotel.entity.Room;
import com.capg.hm.hotel.entity.Users;
import com.capg.hm.hotel.entity.hotel;
import com.capg.hm.hotel.exception.AdminPermissionRequired;
import com.capg.hm.hotel.exception.BookingNotFoundException;
import com.capg.hm.hotel.exception.UserNotLoggedIn;
import com.capg.hm.hotel.repository.bookingdetailsRepository;
import com.capg.hm.hotel.repository.hotelRepository;
import com.capg.hm.hotel.repository.roomRepository;
import com.capg.hm.hotel.repository.userRepository;

@Service
public class bookingdetailsService {
	@Autowired
	private bookingdetailsRepository bookingdetailsRepository;
	@Autowired
	private hotelRepository hotelRepository;
	@Autowired
	private roomRepository roomRepository;
	@Autowired
	private userRepository userRepository;

	public double priceCalculator() {
		double sum = 0.0;
		for (Double r1 : roomService.rateByDay)
			sum += r1;

		return sum;
	}

	//method to add bookingDetails
	public BookingDetails addBookingDetails(BookingDetailsRequestDTO bookingdetails) {
		if (userService.adminLogIn || userService.loggedIn) {
			hotel hotel1 = hotelRepository.findById(bookingdetails.getHotel_id()).get();
			Users user1 = userRepository.findById(bookingdetails.getUsername()).get();

			/*
			 * long diff = bookingdetails.getBooked_to().getDate() -
			 * bookingdetails.getBooked_from().getDate(); long daysBetween =
			 * TimeUnit.DAYS.toDays(diff); double totalAmount = priceCalculator();
			 * totalAmount = totalAmount*daysBetween;
			 */

			List<Room> room1 = new ArrayList<Room>();
			roomRepository.findAllById(bookingdetails.getRoomNo()).forEach(room1::add);

			BookingDetails newbooking = new BookingDetails(bookingdetails.getBooking_id(), hotel1, room1, user1,
					bookingdetails.getBooked_from(), bookingdetails.getBooked_to(), bookingdetails.getNo_of_adults(),
					bookingdetails.getNo_of_children(), bookingdetails.getTotalAmount());
			// totalAmount
			return bookingdetailsRepository.save(newbooking);
		} else {
			throw new UserNotLoggedIn("you are not logged in!!");
		}

	}

	//method to fetch all bookingDetails
	public List<BookingDetails> fetchAllBookingDetails() {
		if (userService.adminLogIn) {
			return bookingdetailsRepository.findAll();
		} else {
			throw new AdminPermissionRequired("admin permission required!!");
		}

	}
	
	//method to fetch bookingDetails by id
	public BookingDetails fetchBookingDetailsById(int booking_id) {
		if (userService.adminLogIn) {
			Optional<BookingDetails> bookingdetails = bookingdetailsRepository.findById(booking_id);

			if (!bookingdetails.isPresent())
				throw new BookingNotFoundException("check booking id again, what you typed is not available with us");

			// System.out.println("booking details with [ "+booking_id+" ] not present");

			return bookingdetails.get();
		} else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}

	}

	//method to delete bookingDetails by id
	public void deleteBookingDetailsById(int booking_id) {
		if (userService.adminLogIn) {
			bookingdetailsRepository.deleteById(booking_id);
		} else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}

	}
	
	//method to update bookingDetails
	public BookingDetails updateBookingDetails(int booking_id, BookingDetailsRequestDTO bookingdetails) {
		if (userService.adminLogIn) {
			Optional<BookingDetails> updatedbookingdetails = bookingdetailsRepository.findById(booking_id);
			if(!updatedbookingdetails.isPresent()) {
				throw new BookingNotFoundException("check booking id again, what you typed is not available with us");
			}
			BookingDetails newbookingdetails=updatedbookingdetails.get();
			if(Objects.nonNull(bookingdetails.getHotel_id())) {
				hotel hotel1 = hotelRepository.findById(bookingdetails.getHotel_id()).get();
				newbookingdetails.setHotel_id(hotel1);
			}
			if(Objects.nonNull(bookingdetails.getUsername())) {
				Users user1 = userRepository.findById(bookingdetails.getUsername()).get();
				newbookingdetails.setUsername(user1);
			}
			if(Objects.nonNull(bookingdetails.getRoomNo())) {
				List<Room> room1 = new ArrayList<Room>();
				roomRepository.findAllById(bookingdetails.getRoomNo()).forEach(room1::add);
				newbookingdetails.setRoomNo(room1);
			}
			
			/*
			 * long diff = bookingdetails.getBooked_to().getDate() -
			 * bookingdetails.getBooked_from().getDate(); long daysBetween =
			 * TimeUnit.DAYS.toDays(diff); double totalAmount = priceCalculator();
			 * totalAmount = totalAmount*daysBetween;
			 */
			if(Objects.nonNull(bookingdetails.getBooked_from())) {
				newbookingdetails.setBooked_from(bookingdetails.getBooked_from());
			}
			
			if(Objects.nonNull(bookingdetails.getBooked_to())) {
				newbookingdetails.setBooked_to(bookingdetails.getBooked_to());
			}
			
			if(Objects.nonNull(bookingdetails.getNo_of_adults())) {
				newbookingdetails.setNo_of_adults(bookingdetails.getNo_of_adults());
			}
			
			if(Objects.nonNull(bookingdetails.getNo_of_children())) {
				newbookingdetails.setNo_of_children(bookingdetails.getNo_of_children());
			}
			
			if(Objects.nonNull(bookingdetails.getTotalAmount())) {
				newbookingdetails.setTotalAmount(bookingdetails.getTotalAmount());
			}

			return bookingdetailsRepository.save(newbookingdetails);
		} else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}

	}

	
}
