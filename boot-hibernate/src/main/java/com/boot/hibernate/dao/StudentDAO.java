package com.boot.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.hibernate.configuration.SessionTemplate;
import com.boot.hibernate.model.Student;

@Repository
public class StudentDAO {

	@Autowired
	SessionTemplate template;

	public void saveStudent(Student student) {
		template.getSession().save(student);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Student> getStudents() {
		return template.getSession().createCriteria(Student.class).list();

	}
}
