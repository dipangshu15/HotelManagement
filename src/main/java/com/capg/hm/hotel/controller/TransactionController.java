package com.capg.hm.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hm.hotel.entity.Transactions;
import com.capg.hm.hotel.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService tran;
	
	@PostMapping("/transaction/addTransaction")  //end point to add transaction
	public Transactions addTransaction(@RequestBody Transactions b) {
		tran.addTransaction(b);
		return b;
	}
	
	@GetMapping("/transaction/getAllTransaction")  //end point to get all transaction
	public List<Transactions> getAllTransaction(){
		return tran.getAllTransaction();
	}
}
