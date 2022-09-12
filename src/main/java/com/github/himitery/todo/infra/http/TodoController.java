package com.github.himitery.todo.infra.http;

import com.github.himitery.todo.application.TodoServiceImpl;
import com.github.himitery.todo.domain.Todo;
import com.github.himitery.todo.infra.http.request.CreateTodoRequest;
import com.github.himitery.todo.infra.http.request.UpdateTodoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

	private final TodoServiceImpl todoService;

	@QueryMapping
	public Todo todo(@Argument String todoId) {
		return todoService.getOne(todoId);
	}

	@QueryMapping
	public List<Todo> todos() {
		return todoService.getAll();
	}

	@MutationMapping
	public Todo createTodo(@Argument CreateTodoRequest props) {
		return todoService.create(props);
	}

	@MutationMapping
	public Todo updateTodo(@Argument UpdateTodoRequest props) {
		return todoService.update(props);
	}

	@MutationMapping
	public Todo updateTodoStatus(@Argument String todoId) {
		return todoService.updateStatus(todoId);
	}

	@MutationMapping
	public Boolean deleteTodo(@Argument String todoId) {
		return todoService.delete(todoId);
	}
}
