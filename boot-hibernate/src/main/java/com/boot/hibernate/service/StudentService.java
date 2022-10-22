package com.boot.hibernate.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.hibernate.dao.StudentDAO;
import com.boot.hibernate.model.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentDAO studentDAO;

	public String saveStudent(Student student) {
		Serializable saveStudent = studentDAO.saveStudent(student);
		return "saved sucessfully with Id " + saveStudent;
	}

	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

}
