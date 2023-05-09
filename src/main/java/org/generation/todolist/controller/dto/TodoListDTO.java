package org.generation.todolist.controller.dto;

import java.sql.Date;

// The TodoListDTO Class will interface with the Client (Browser) for any HTTP request
//(e.g. GET, POST, PUT, DELETE methods) and is wired to the TodoListService Class to perform
//getItem, addItem, findItem, updateItem and deleteItem.
public class TodoListDTO {
	// variable names same as table column names
	// id is excluded as it is auto-generated
	private String title;
	private String description;
	private Date targetDate;

	// Constructor
	public TodoListDTO(String title, String description, Date targetDate) {
		this.title = title;
		this.description = description;
		this.targetDate = targetDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
}
