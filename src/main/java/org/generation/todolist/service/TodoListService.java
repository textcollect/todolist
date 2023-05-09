package org.generation.todolist.service;

import org.generation.todolist.repository.entity.TodoList;

import java.util.List;

public interface TodoListService {
	//save method is for 2 purposes - Create new todolist entry & Update existing todolist
	TodoList save(TodoList todoList);

	//Delete todolist entry from database - based on id
	void deleteById(int listId);

	//Read all todolist entries from database
	List<TodoList> all();

	//Read a todolist entry from database based on id
	TodoList findById(int listId);
}
