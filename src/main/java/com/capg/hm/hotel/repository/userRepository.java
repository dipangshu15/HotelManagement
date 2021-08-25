package com.capg.hm.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hm.hotel.entity.Users;

@Repository
public interface userRepository extends JpaRepository<Users,String>{
	public Optional<Users> findByUserName(String username);

	//public Long deleteByUserName(String username);

}
