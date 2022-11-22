package com.ratna.mongo.boot.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.mongo.boot.exceptions.TodoCollectionException;
import com.ratna.mongo.boot.model.TodoDTO;
import com.ratna.mongo.boot.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public ResponseEntity<?> getAllTodos() {
		List<TodoDTO> allTodos = todoService.getAllTodos();
		return new ResponseEntity<List<TodoDTO>>(allTodos, !allTodos.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO document)
			throws ConstraintViolationException, TodoCollectionException {
		return new ResponseEntity<TodoDTO>(todoService.createTodo(document), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTodo(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<TodoDTO>(todoService.getTodo(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable("id") String id, @RequestBody TodoDTO todoDTO) {
		try {
			return new ResponseEntity<TodoDTO>(todoService.updateTodo(id, todoDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable("id") String id) {
		Boolean deleteTodo = todoService.deleteTodo(id);
		if (deleteTodo != null && deleteTodo.booleanValue()) {
			return new ResponseEntity<String>("Sucessfully deleted Todo with id " + id, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("unable to delete the todo as no document available with id " + id,
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/top3Bycompleted/{flag}")
	public ResponseEntity<?> findTop3CompletedTodos(@PathVariable("flag") Boolean flag) {
		List<TodoDTO> allTodos = todoService.findTop3CompletedTodos(flag);
		return new ResponseEntity<List<TodoDTO>>(allTodos, !allTodos.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
