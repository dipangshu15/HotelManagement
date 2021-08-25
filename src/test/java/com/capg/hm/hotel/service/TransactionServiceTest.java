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

import com.capg.hm.hotel.entity.Transactions;
import com.capg.hm.hotel.repository.TransactionRepository;

@SpringBootTest
class TransactionServiceTest {
	@Autowired
	private TransactionService tran;
	@MockBean
	private TransactionRepository transrepo;
	
	Transactions transaction;
	@BeforeEach
	void setUp() throws Exception {
		com.capg.hm.hotel.service.userService.setAdminLogIn(true);
		com.capg.hm.hotel.service.userService.setLoggedIn(true);
		
		transaction=new Transactions();
		
		transaction.setTransaction_id(10);
		transaction.setAmount(87.67);
		
		//transaction = Transactions.builder().transaction_id(10).amount(87.67).build();
		List<Transactions> list = new ArrayList<Transactions>(){ {add(transaction);}};

				Mockito.when(transrepo.save(transaction)).thenReturn(transaction);
				Mockito.when(transrepo.findAll()).thenReturn(list);
	}


	@Test
	@DisplayName("testing saving the transaction")
	void saveTransactionTest()
	{
		assertEquals(transaction,tran.addTransaction(transaction));
	}
	
	
	 @Test
	 @DisplayName("testing fetch all transaction") 
	  void getAllTransactionTest() {
	  List<Transactions> list = new ArrayList<Transactions>(){ {add(transaction);}};
	  assertEquals(list,tran.getAllTransaction()); }
	 
}
