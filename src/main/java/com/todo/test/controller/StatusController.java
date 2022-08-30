package com.todo.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.test.entity.Action;
import com.todo.test.entity.Status;
import com.todo.test.repository.UserRepository;
import com.todo.test.service.StatusService;

@RestController
@RequestMapping("/api/v1")
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	//Update status from pending to completed or declined
	@PutMapping("/status/{statusId}/{statusb}")
	public void updateStatus(@PathVariable("statusId") int id,@PathVariable(name = "statusb") String statusb) {
		statusService.updateStatus(id,statusb);
	}
	
	//Get Action Title using assignedto(userId) and status
	@GetMapping("/title/{userId}/{s}")
	public List<Action> getTitles(@PathVariable int userId, @PathVariable String s) {
		return statusService.getTitles(userId,s);
	}
	
	
	//Initially add status to pending
	@PostMapping("/status")
	public Status addStatus(@RequestBody int userId) {
		return statusService.addStatus(userId);
	}
	
	@GetMapping("/{statusId}")
	public String getStatus(@PathVariable int statusId) {
		return statusService.getStatus(statusId);
	}
}
