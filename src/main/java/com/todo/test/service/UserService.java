package com.todo.test.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.test.entity.Action;
import com.todo.test.entity.Users;
import com.todo.test.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	//save userDetails
	public Users createUser(Users user) {
		user.setUUID();
		userRepository.save(user);
		return user;
	}
	
	//get userDetails by id
	public Users getUserDetails(int id) {
		Users user;
		user = userRepository.findById(id).get();
		return user;
	}
	
	//get userDetails by name
	public List<Users> getuserName() {
		List<Users> user = new ArrayList<Users>();
		userRepository.findAll().forEach(user1 -> user.add(user1));
		return user;
	}
	
	//get userDetail using contactNumber
	public Users getUserByNumber(String contactNumber) {
		Users u ;
		u = userRepository.findByContactNumber(contactNumber);
		return u;
	}
	
}
