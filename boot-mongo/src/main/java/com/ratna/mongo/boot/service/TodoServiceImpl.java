package com.ratna.mongo.boot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.mongo.boot.exceptions.TodoCollectionException;
import com.ratna.mongo.boot.model.TodoDTO;
import com.ratna.mongo.boot.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<TodoDTO> getAllTodos() {
		List<TodoDTO> list = todoRepository.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public TodoDTO createTodo(TodoDTO todoDTO)
			throws ConstraintViolationException, UnexpectedTypeException, TodoCollectionException {
		Optional<TodoDTO> findByTodo = todoRepository.findByTodo(todoDTO.getTodo());
		if (findByTodo.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists(todoDTO.getTodo()));
		} else {
			todoDTO.setCreatedAt(new Date(System.currentTimeMillis()));
			return todoRepository.save(todoDTO);
		}

	}

	@Override
	public TodoDTO getTodo(String id) throws TodoCollectionException {
		Optional<TodoDTO> findById = todoRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}
	}

	@Override
	public TodoDTO updateTodo(String id, TodoDTO todoDTO)
			throws ConstraintViolationException, UnexpectedTypeException, TodoCollectionException {
		Optional<TodoDTO> findById = todoRepository.findById(id);
		Optional<TodoDTO> findByTodo = todoRepository.findByTodo(todoDTO.getTodo());
		if (findById.isPresent()) {
			if (findByTodo.isPresent() && !(findByTodo.get().getId().equalsIgnoreCase(findById.get().getId()))) {
				throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists(todoDTO.getTodo()));
			}
			TodoDTO todoSaved = findById.get();
			todoSaved.setCompleted(todoDTO.getCompleted() != null ? todoDTO.getCompleted() : todoSaved.getCompleted());
			todoSaved.setTodo(todoDTO.getTodo() != null ? todoDTO.getTodo() : todoSaved.getTodo());
			todoSaved.setDescription(
					todoDTO.getDescription() != null ? todoDTO.getDescription() : todoSaved.getDescription());
			todoSaved.setUpdatedAt(new Date(System.currentTimeMillis()));
			return todoRepository.save(todoSaved);
		} else {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}
	}

	@Override
	public Boolean deleteTodo(String id) {
		Boolean isdocumentDeleted = true;
		try {
			todoRepository.deleteById(id);
		} catch (Exception e) {
			isdocumentDeleted = false;
		}
		return isdocumentDeleted;
	}

	@Override
	public List<TodoDTO> findTop3CompletedTodos(Boolean flag) {
		List<TodoDTO> list = todoRepository.findTop3ByCompleted(flag);
		if (!list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public List<TodoDTO> findTodosByRegex(String regex) {
		return todoRepository.findTodosByRegexpName(regex);
	}

	@Override
	public List<TodoDTO> findByTodoStartingWith(String todo) {
		return todoRepository.findByTodoStartingWith(todo);
	}

	@Override
	public List<TodoDTO> findByTodoEndingWith(String todo) {
		return todoRepository.findByTodoEndingWith(todo);
	}
}
