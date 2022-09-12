package com.github.himitery.todo.infra.persistence;

import com.github.himitery.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoJpaRepository extends JpaRepository<Todo, UUID> {
}
