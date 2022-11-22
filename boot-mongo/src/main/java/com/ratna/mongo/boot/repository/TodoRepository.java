package com.ratna.mongo.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ratna.mongo.boot.model.TodoDTO;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {

	Optional<TodoDTO> findByTodo(String todo);

	List<TodoDTO> findTop3ByCompleted(Boolean flag);
}
