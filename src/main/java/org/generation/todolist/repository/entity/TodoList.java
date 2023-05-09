package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TodoListDTO;

import java.text.DateFormat;
import java.sql.Date;

//TodoList is the entity class to use to map against the table from the database
@Entity
public class TodoList {
	//Properties/attributes - will be mapped to the columns of the database table
	//Need to use the Wrapper class on primitive data types - need to pass the datatype
	// as an object to CRUDRepository Class (provided by SpringBoot framework)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //retrieve todoitem by ID - has to be an object
	private String title;
	private String description;
	private Date targetDate;

	// TodoList class used to map w the Database table
	// Any CRUD operation, JPA will make use of this Item class to map
	// For Read or Delete operation, the JPA requires empty constructor to
	//populate all the records from the db
	protected TodoList() {
		// no-args constructor required by JPA spec
		// this one is protected since it should not be used directly
	}

	// DTO = Data Transfer Object
	// Create and Update operation, JPA requires the TodoListDTO object to
	//be sent via the controller
	public TodoList(TodoListDTO todoListDTO) {
		//Transfer the object (with the data) to Entity Class from TodoListDTO for mapping
		// with the database table columns and to be able to save the data in the columns
		this.title = todoListDTO.getTitle();
		this.description = todoListDTO.getDescription();
		this.targetDate = todoListDTO.getTargetDate();
	}

	// Getter & Setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Todo List{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", targetDate='" + targetDate + '}';
	}
}
