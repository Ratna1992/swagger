package com.ratna.mongo.boot.service;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import com.ratna.mongo.boot.exceptions.TodoCollectionException;
import com.ratna.mongo.boot.model.TodoDTO;

public interface TodoService {

	public List<TodoDTO> getAllTodos();

	public TodoDTO createTodo(TodoDTO todoDTO)
			throws ConstraintViolationException, UnexpectedTypeException, TodoCollectionException;

	public TodoDTO getTodo(String id) throws TodoCollectionException;

	public TodoDTO updateTodo(String id, TodoDTO todoDTO)throws  ConstraintViolationException, UnexpectedTypeException, TodoCollectionException;

	public Boolean deleteTodo(String id);
	
	public List<TodoDTO> findTop3CompletedTodos(Boolean flag);
}
