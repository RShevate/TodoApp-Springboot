package com.todo.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.test.entity.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>{

	public List<Action> findByAssignedTo(int userId);
	public List<Action> findByCreatedBy(int userId);
}

