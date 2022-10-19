package com.ratna.boot.secure.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.boot.secure.rest.service.EmployeeDataService;

@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeDataService emp;

	@GetMapping("/getEmpList")
	public ResponseEntity<Map<String, Object>> getEmployeeDataList() {
		return new ResponseEntity<>(emp.getEmployeeDataList(), HttpStatus.OK);

	}

}
