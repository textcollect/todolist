package org.generation.todolist.repository;

import org.generation.todolist.repository.entity.TodoList;
import org.springframework.data.repository.CrudRepository;

// This will be auto-implemented by Spring
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {
}
