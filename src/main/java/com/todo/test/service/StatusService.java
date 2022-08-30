package com.todo.test.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.test.entity.Action;
import com.todo.test.entity.Status;
import com.todo.test.repository.ActionRepository;
import com.todo.test.repository.StatusRepository;
import com.todo.test.repository.UserRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ActionRepository actionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//update status from pending to completed or decline
	public void updateStatus(int id,String statusb) {
		Status status = statusRepository.findById(id).get();
		//check whether status is decline
		if(statusb.equals("decline")) {
			status.setStatus("Decline");
		}
		else {
			status.setStatus("Completed");
		}
		statusRepository.save(status);
	}

	//Get status details
	public Status getTask(int id) {
		Status status = statusRepository.findById(id).get();
		return status;
	}
	
	//Get action title 
	public List<Action> getTitles(int userId, String s) {
		List<Action> tasks =actionRepository.findByAssignedTo(userId);	
		List<Action> result = new ArrayList<>();
		if(s.equals("Pending"))
			{
				for(Action a: tasks) {
					String st = statusRepository.findById(a.getStatusId()).get().getStatus();
					if(st.equals("Pending"))
						result.add(a);
				}
			}
			else
			{
				for(Action a: tasks) {
					String st = statusRepository.findById(a.getStatusId()).get().getStatus();
					if(!st.equals("Pending"))
						result.add(a);
				}
				
			}
		return result;
	 }
	
	
	public List<String> getAllStatusAssignedToUser(int userId) {
		List<Action> tasks =actionRepository.findByAssignedTo(userId);
		List<String> result= new ArrayList<>();
		for(Action a:tasks) {
			String st = statusRepository.findById(a.getStatusId()).get().getStatus();
			result.add(st);
		}
		return result;
	 }
	
	
	public List<String> getAllUserNameAssignedToUser(int userId) {
		List<Action> tasks =actionRepository.findByAssignedTo(userId);
		List<String> result= new ArrayList<>();
		for(Action a:tasks) {
			String st = userRepository.findById(a.getCreatedBy()).get().getName();
			result.add(st);
		}
		return result;
	 }
	
	
	public String getStatus(int statusId) {
		Status s = statusRepository.findById(statusId).get();
		return s.getStatus();
	 }
	
		

	 //Initially set assigned task status to pending
	 public Status addStatus(int userId) {
		Status temp = new Status();
		temp.setStatus("Pending");
		temp.setUserId(userId);
		return statusRepository.save(temp);
	 }
	
}
