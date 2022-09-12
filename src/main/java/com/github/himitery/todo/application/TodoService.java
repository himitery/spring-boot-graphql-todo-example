package com.github.himitery.todo.application;

import com.github.himitery.todo.domain.Todo;
import com.github.himitery.todo.infra.http.request.CreateTodoRequest;
import com.github.himitery.todo.infra.http.request.UpdateTodoRequest;

import java.util.List;

public interface TodoService {
	Todo getOne(String todoId);

	List<Todo> getAll();

	Todo create(CreateTodoRequest request);

	Todo update(UpdateTodoRequest request);

	Todo updateStatus(String todoId);

	Boolean delete(String todoId);
}
