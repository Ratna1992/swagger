package com.core.spring.intro.beans;

public class Student {

	private String name;
	private String department;
	private String id;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + ", id=" + id + ", age=" + age + "]";
	}

	public Student(String name, String department, String id, Integer age) {
		super();
		this.name = name;
		this.department = department;
		this.id = id;
		this.age = age;
	}

	public Student() {
		super();
	}

}
