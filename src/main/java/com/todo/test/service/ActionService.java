package com.todo.test.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.test.entity.Action;
import com.todo.test.entity.Status;
import com.todo.test.repository.ActionRepository;

@Service
public class ActionService {
	
	@Autowired
	private ActionRepository actionRepository;
	
	@Autowired
	StatusService statusService;
	
	@Autowired
	private UserService userService;
	
	//Create Action 
	public Action createTask(Action action) {
		//String userName="Gaurav Kalje";//correct using angular
		//int createdBy=1;//correct from login detail
		int uid = action.getAssignedTo();  //get userId from userName
		//action.setAssignedTo(uid); 
		//action.setCreatedBy(createdBy);
		action.setCreatedDateTime(new Date(System.currentTimeMillis()));
		action.setModifiedDateTime(new Date(System.currentTimeMillis()));
		Status status = statusService.addStatus(uid);
		action.setStatusId(status.getStatusId());
		actionRepository.save(action);
		return action;  
	}
	
	//Get action details by actionId
	public Action getTask(int id) {
		Action action = actionRepository.findById(id).get();
		return action;
	}

	public List<Action> gettitlebyuserId(int userId) {
		// TODO Auto-generated method stub
		List<Action> a = actionRepository.findByAssignedTo(userId);
		return a;
	}
}

