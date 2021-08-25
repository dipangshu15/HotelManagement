package com.capg.hm.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hm.hotel.entity.Transactions;
import com.capg.hm.hotel.exception.AdminPermissionRequired;
import com.capg.hm.hotel.exception.UserNotLoggedIn;
import com.capg.hm.hotel.repository.TransactionRepository;

@Service
public class TransactionService implements TransactionServiceInterface {
	@Autowired
	private TransactionRepository transRepo;
	
	//method to add new transaction
	public Transactions addTransaction(Transactions tran) {
		if(userService.adminLogIn||userService.loggedIn) {
			return transRepo.save(tran);
		}
		else {
			throw new UserNotLoggedIn("you are not logged in!!");
		}
		
	}
	
	//method to get all transaction
	public List<Transactions> getAllTransaction(){
		if(userService.adminLogIn) {
			List<Transactions> list=new ArrayList<Transactions>();
			transRepo.findAll().forEach(list::add);
			return list;
		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}
		
	}
	
}
