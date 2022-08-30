package com.todo.test.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//create table Action
@Table(name="Action")
public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="actionTitle")
	private String actionTitle;
	
	@Column(name="description")
	private String description;
	
	@Column(name="createdDateTime")
	private Date createdDateTime;
	
	@Column(name="modifiedDateTime")
	private Date modifiedDateTime;
	
	@Column(name="priority")
	private String priority;
	
	private int createdBy;
	private int assignedTo;
	private int statusId;
	 
	public Action() {
		super();
	}

	public Action(int id, String actionTitle, String description, Date createdDateTime, Date modifiedDateTime,
			String priority, int createdBy, int assignedTo, int statusId) {
		super();
		this.id = id;
		this.actionTitle = actionTitle;
		this.description = description;
		this.createdDateTime = createdDateTime;
		this.modifiedDateTime = modifiedDateTime;
		this.priority = priority;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.statusId = statusId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionTitle() {
		return actionTitle;
	}

	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}	
}

