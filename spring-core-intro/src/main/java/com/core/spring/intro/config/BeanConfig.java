package com.core.spring.intro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.spring.intro.beans.Student;

@Configuration
public class BeanConfig {

	@Bean("getStudent")
	public Student getStudent() {
		return new Student();
	}

	@Bean("getStudentPara")
	public Student getStudentPara() {
		return new Student();
	}

}
