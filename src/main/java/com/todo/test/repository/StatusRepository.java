package com.todo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.test.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

	
}
