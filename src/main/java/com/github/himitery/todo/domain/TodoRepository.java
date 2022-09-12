package com.github.himitery.todo.domain;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
	Optional<Todo> findById(String todoId);

	List<Todo> findAll();

	Todo save(Todo todo);

	void deleteById(String todoId);
}
