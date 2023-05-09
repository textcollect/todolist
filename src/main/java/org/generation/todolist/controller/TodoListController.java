package org.generation.todolist.controller;

import org.generation.todolist.controller.dto.TodoListDTO;
import org.generation.todolist.repository.entity.TodoList;
import org.generation.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/todo") //provides a URL for frontend to call the API endpoint
public class TodoListController {
	private final TodoListService todoListService;

	// dependency injection to access TodoListServiceMySQL methods
	// TodoListService is the interface for TodoListServiceMySQL
	public TodoListController(@Autowired TodoListService todoListService) {
		this.todoListService = todoListService;
	}

	// API endpoint to return all todolist entries to the front-end
	// frontend will issue a GET http request
	@CrossOrigin
	@GetMapping("/all")
	public Iterable<TodoList> getList() {
		return todoListService.all();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public TodoList findEntryById(@PathVariable Integer id) {
		return todoListService.findById(id);
	}

	@CrossOrigin
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable Integer id) {
		todoListService.deleteById(id);
	}

	// Add & save new todolist entry to TodoListService object which actually saves to the TodoListRepository
	// which is linked to the TodoList table in db
	@CrossOrigin
	@PostMapping("/add")
	public void save(@RequestParam(name = "title", required = true) String title,
					 @RequestParam(name = "description", required = true) String description,
					 @RequestParam(name = "targetDate", required = true) Date targetDate) {

		TodoListDTO todoListDTO = new TodoListDTO(title, description, targetDate);
		todoListService.save(new TodoList(todoListDTO));
	}
}
