package com.github.himitery.todo.application;

import com.github.himitery.todo.domain.Todo;
import com.github.himitery.todo.infra.http.request.CreateTodoRequest;
import com.github.himitery.todo.infra.http.request.UpdateTodoRequest;
import com.github.himitery.todo.infra.persistence.TodoRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {

	private final TodoRepositoryImpl todoRepository;

	@Override
	public Todo getOne(String todoId) {
		return todoRepository.findById(todoId).orElse(null);
	}

	@Override
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}

	@Override
	@Transactional
	public Todo create(CreateTodoRequest request) {
		return todoRepository.save(
				Todo.builder()
						.title(request.getTitle())
						.content(request.getContent())
						.build()
		);
	}

	@Override
	@Transactional
	public Todo update(UpdateTodoRequest request) {
		Todo todo = todoRepository.findById(request.getId())
				.orElseThrow(() -> new IllegalArgumentException("Todo를 조회할 수 없습니다."));

		return todo.update(request.getTitle(), request.getContent());
	}

	@Override
	@Transactional
	public Todo updateStatus(String todoId) {
		Todo todo = todoRepository.findById(todoId)
				.orElseThrow(() -> new IllegalArgumentException("Todo를 조회할 수 없습니다."));

		return todo.updateStatus();
	}

	@Override
	@Transactional
	public Boolean delete(String todoId) {
		todoRepository.deleteById(todoId);

		return true;
	}
}
