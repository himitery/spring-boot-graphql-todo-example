package com.github.himitery.todo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Column(nullable = false)
	private String title;

	@Column
	private String content;

	@Column(nullable = false)
	private Boolean status;

	@Builder
	public Todo(String title, String content) {
		this.title = title;
		this.content = content;
		this.status = false;
	}

	public Todo update(@Nullable String title, @Nullable String content) {
		if (title != null) {
			this.title = title;
		}
		if (content != null) {
			this.content = content;
		}

		return this;
	}

	public Todo updateStatus() {
		this.status = !status;

		return this;
	}
}
