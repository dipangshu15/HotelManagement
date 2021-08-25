package com.capg.hm.hotel.service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capg.hm.hotel.entity.Admin;
import com.capg.hm.hotel.entity.Users;
import com.capg.hm.hotel.entity.hotel;
import com.capg.hm.hotel.exception.AdminPermissionRequired;
import com.capg.hm.hotel.exception.HotelNotFoundException;
import com.capg.hm.hotel.exception.LogInException;
import com.capg.hm.hotel.exception.UserNotFoundException;
import com.capg.hm.hotel.repository.userRepository;

@Service
public class userService {
	
	static Boolean loggedIn=true;  //user login
	static Boolean adminLogIn=true; //admin login
	@Autowired
	private userRepository repository;  //user repository
	
	//method to add users
	public Users addUser(Users user)
	{
		if(userService.adminLogIn) {
			Users savedUser = repository.save(user);
			return savedUser;
		}
		else {
			if(user.getRole().equals("admin")) {
				throw new AdminPermissionRequired("admin permission required!!!");
			}
			Users savedUser = repository.save(user);
			return savedUser;
		}
	}
	
	//method to log in users
	public ResponseEntity<String> logInUser(Users user) throws LogInException, UserNotFoundException
	{
		Optional<Users> getUser = repository.findByUserName(user.getUserName());
		
		if(!getUser.isPresent())
		{
			throw new UserNotFoundException("User not found..!!");
		}
		
		Users u = getUser.get();
		
		if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword()))
		{
			//System.out.println("******************************************"+u.getRole());
			if(u.getRole().equals("admin")) {
				loggedIn=true;
				adminLogIn=true;
			    return new ResponseEntity<String>("Welcome Admin..!!", HttpStatus.OK);
			}
			else {
				adminLogIn=true;
				loggedIn=true;
				return new ResponseEntity<String>("Welcome user..!!", HttpStatus.OK);
			}
			
		}
		else
		{
			throw new LogInException("Invalid Username or Password");
		}
	}
	
	//method to update users
	public Users updateUser(String username,Users user)
	{
		if(userService.adminLogIn || userService.loggedIn) {
			Optional<Users> h=repository.findByUserName(username);
			if(!h.isPresent()) {
				throw new HotelNotFoundException("no user present by this username");
			}
			
			
			Users result=h.get();
			if(Objects.nonNull(user.getUserName())) {
				result.setUserName(user.getUserName());
			}
			if(Objects.nonNull(user.getAddress())) {
				result.setAddress(user.getAddress());
			}
			if(Objects.nonNull(user.getEmail())) {
				result.setEmail(user.getEmail());
			}
			if(Objects.nonNull(user.getMobile())) {
				result.setMobile(user.getMobile());
			}
			if(Objects.nonNull(user.getPassword())) {
				result.setPassword(result.getPassword());
			}
			if(Objects.nonNull(user.getRole())) {
				if(userService.adminLogIn) {
					result.setRole(user.getRole());
				}
				else {
					throw new AdminPermissionRequired("admin permission is required!!");
				}
			}
			
			repository.save(result);
			return result;
		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!");
		}
		
	}
	
	//method to remove users
	public String removeUser (String username) throws UserNotFoundException
	{
		if(adminLogIn) {
		Optional<Users> temp = repository.findByUserName(username);
		if(!temp.isPresent())
		{
			throw new UserNotFoundException("User not find...!!");
		}
		else
		{
			repository.delete(temp.get());
		}
		return "User deleted...!!";
	  }
		else {
			return "admin permission required!!";
		}
		
	}
	
	//method to display user by username
	public Optional<Users> showUser(String username) throws UserNotFoundException
	{
		Optional<Users> user = repository.findByUserName(username);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User not found...!!");
		}
		else
		{
			return user;
		}
	}
	
	//method to display all users
	public ArrayList<Users> showAllUser()
	{
		if(adminLogIn) {
			ArrayList<Users> userList = new ArrayList<>();
			userList = (ArrayList<Users>) repository.findAll();
			return userList;
		}
		else {
			throw new AdminPermissionRequired("admin permission is required!!!");
		}
	}

	public static Boolean getLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(Boolean loggedIn) {
		userService.loggedIn = loggedIn;
	}

	public static Boolean getAdminLogIn() {
		return adminLogIn;
	}

	public static void setAdminLogIn(Boolean adminLogIn) {
		userService.adminLogIn = adminLogIn;
	}
	
	
}
