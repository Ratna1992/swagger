package com.example.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class representing a person tracked by the application.")
public class Person {

	@NotNull
	@ApiModelProperty(notes = "Unique identifier of the person. No two persons can have the same id.", example = "1", required = true, position = 0)
	private int id;

	@NotBlank
	@Size(min = 1, max = 20)
	@ApiModelProperty(notes = "First name of the person.", example = "John", required = true, position = 1)
	private String firstName;

	@NotBlank
	@Size(min = 1, max = 20)
	@ApiModelProperty(notes = "Last name of the person.", example = "Doe", required = true, position = 2)
	private String lastName;

	@Min(0)
	@Max(100)
	@ApiModelProperty(notes = "Age of the person. Non-negative integer", example = "42", position = 3)
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
