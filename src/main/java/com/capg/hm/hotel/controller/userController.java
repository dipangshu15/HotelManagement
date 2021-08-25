package com.capg.hm.hotel.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hm.hotel.entity.Users;
import com.capg.hm.hotel.exception.LogInException;
import com.capg.hm.hotel.exception.UserNotFoundException;
import com.capg.hm.hotel.service.userService;

@RestController
public class userController {
	@Autowired
	private userService userService;
	
	@PostMapping("/user/saveUser")
	public Users addUser(@Valid @RequestBody Users user)  //end point to add users
	{
		//System.out.println(user.getMobile());
		return userService.addUser(user);	
	}
	
	@PostMapping("/user/login")  //end point to log in user
	public ResponseEntity<String> logInUser(@RequestBody Users user ) throws LogInException, UserNotFoundException
	{
		return userService.logInUser(user);
	}
	
	@PutMapping("/user/updateUser/{name}")  //end point to update user
	public Users updateUser(@PathVariable("name") String userName,@RequestBody Users user)
	{
		//System.out.println("################### "+userName);
		return userService.updateUser(userName,user);
	}
	
	@DeleteMapping("/user/deleteUser/{username}")  //end point to delete user
	public String removeUser(@PathVariable("username") String userName) throws UserNotFoundException
	{
		return userService.removeUser(userName);	
	}
	
	@GetMapping("/user/getUser/{username}")  //end point to get user by username
	public Optional<Users> showUser(@PathVariable("username") String username) throws UserNotFoundException
	{
		return userService.showUser(username);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/user/getAllUser")  //end point to get all users
	public ArrayList<Users> showAllUser()
	{
		return userService.showAllUser();
	}
	
	@GetMapping("/user/logOut")  //end point to log out
	public String logout() {
		userService.setAdminLogIn(false);
		userService.setLoggedIn(false);
		return "successfully logged out"; 
	}
	
	
}
