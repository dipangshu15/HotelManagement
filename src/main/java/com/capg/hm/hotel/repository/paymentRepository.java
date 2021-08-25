package com.capg.hm.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hm.hotel.entity.Payment;

@Repository
public interface paymentRepository extends JpaRepository<Payment,Integer>{

}
