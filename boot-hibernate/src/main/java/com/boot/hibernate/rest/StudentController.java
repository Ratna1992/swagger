package com.boot.hibernate.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.hibernate.model.Student;
import com.boot.hibernate.service.StudentService;

@RestController
@RequestMapping("/v1/cms")
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/student")
	public String saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/student")
	public List<Student> getStudents() {
		return service.getStudents();
	}

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id) {
		return service.getStudentById(id);
	}

}
