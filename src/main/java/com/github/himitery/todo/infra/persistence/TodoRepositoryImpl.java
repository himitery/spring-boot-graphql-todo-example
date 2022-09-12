package com.github.himitery.todo.infra.persistence;

import com.github.himitery.todo.domain.Todo;
import com.github.himitery.todo.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {
	private final TodoJpaRepository todoJpaRepository;

	@Override
	public Optional<Todo> findById(String todoId) {
		return todoJpaRepository.findById(UUID.fromString(todoId));
	}

	@Override
	public List<Todo> findAll() {
		return todoJpaRepository.findAll();
	}

	@Override
	public Todo save(Todo todo) {
		return todoJpaRepository.save(todo);
	}

	@Override
	public void deleteById(String todoId) {
		todoJpaRepository.deleteById(UUID.fromString(todoId));
	}
}
