package com.github.himitery.todo.infra.http.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateTodoRequest {
	private String title;
	private String content;
}
