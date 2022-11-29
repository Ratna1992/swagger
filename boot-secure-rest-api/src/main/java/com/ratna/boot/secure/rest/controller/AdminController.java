package com.ratna.boot.secure.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.boot.secure.rest.model.Employee;
import com.ratna.boot.secure.rest.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String createUser(@RequestBody Employee user) {
		adminService.createUser(user);
		return "user created with :: " + user.getUserId();
	}

	@GetMapping("/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<Employee> listAllUsers() throws Exception {
		try {
			return adminService.listAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
