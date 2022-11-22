package com.ratna.mongo.boot.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "todo")
public class TodoDTO {

	@Id
	private String id;
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	private String todo;
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	private String description;
	@NotNull(message = "cannot be null")
	private Boolean completed;
	private Date createdAt;
	private Date updatedAt;
}
