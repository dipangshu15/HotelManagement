package com.capg.hm.hotel.repository;

import javax.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hm.hotel.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer>{

}
