package com.ratna.boot.secure.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ratna.boot.secure.rest.model.Employee;
import com.ratna.boot.secure.rest.repository.EmployeeRepository;

@Service
public class AdminService {

	@Autowired
	private EmployeeRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public Employee createUser(Employee user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public List<Employee> listAllUsers() {
		List<Employee> users = new ArrayList<Employee>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

}
