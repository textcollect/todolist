package org.generation.todolist.service;

import org.generation.todolist.repository.TodoListRepository;
import org.generation.todolist.repository.entity.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoListServiceMySQL implements TodoListService {

	//This TodoListServiceMySQL class has to depend on another class object to perform
	// actions (e.g. save, delete, all, findItemById
	//dependent object class is the CRUDRepository class that is provided by Spring boot
	//to perform dependency injection -> access the CRUDRepository class through the
	// TodoListRepository interface that we have created
	private final TodoListRepository todoListRepository;

	//Dependency Injection of another class object to this class object can be done with
	// @Autowired annotation
	public TodoListServiceMySQL(@Autowired TodoListRepository todoListRepository) {
		this.todoListRepository = todoListRepository;
	}

	@Override
	public TodoList save(TodoList todoList) {
		return todoListRepository.save(todoList);
	}

	@Override
	public void deleteById(int listId) {}

	@Override
	public List<TodoList> all() {
		List<TodoList> result = new ArrayList<>();
		todoListRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public TodoList findById(int listId) {
		// Optional is List that accept either a NULL(empty) or a TodoList
		Optional<TodoList> todoList =todoListRepository.findById(listId);
		return todoList.get();
	}
}
