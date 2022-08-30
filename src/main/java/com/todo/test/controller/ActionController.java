package com.todo.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.test.entity.Action;
import com.todo.test.entity.Users;
import com.todo.test.service.ActionService;
import com.todo.test.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class ActionController {
	
	@Autowired
	ActionService actionService;
	
	@Autowired
	UserService userService;
	
	//Create Action 
	@PostMapping("/action")
	public Action createTask(@RequestBody Action action) {    
		return actionService.createTask(action);
	}
	
	//Get action details by actionId
	@GetMapping("/action/{id}")
	public Action getTask(@PathVariable int id) {
		return actionService.getTask(id);
	}
	
	@GetMapping("/alltitles/{userId}")
	public List<Action> gettitlebyuserId(@PathVariable int userId) {
		return actionService.gettitlebyuserId(userId);
	}
}
