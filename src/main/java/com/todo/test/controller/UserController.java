package com.todo.test.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todo.test.entity.Users;
import com.todo.test.service.UserService;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;

	//Create users 
	@PostMapping("/user")
	public Users createUsers(@RequestBody Users users) {
		return userService.createUser(users);
	}
	
	//Get userDetails using userId
	@GetMapping("/user/{userId}")
	public Users userDetails(@PathVariable int userId) {
		return userService.getUserDetails(userId);
	}
	
	//Get userDetail from userName
	@GetMapping("/alluserNames")
	public List<Users> getuserName() {
		return userService.getuserName();
	}
	
	//Get userDetail by using contactNumber
	@GetMapping("/userlogin/{contactNumber}")
	public Users getUserByNumber(@PathVariable String contactNumber) {
		return userService.getUserByNumber(contactNumber);
	}
	
}
