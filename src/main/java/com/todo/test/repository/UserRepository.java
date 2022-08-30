package com.todo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.test.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	//Users findByName(String userName);
	Users findByContactNumber(String contactNumber);	
}
