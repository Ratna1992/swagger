package com.ratna.boot.secure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/student")
public class StudentController {

	@GetMapping("/getCollegeDetails")
	public ResponseEntity<String> getStudentDataList() {
		return new ResponseEntity<>("Nimra Institute of Science & Technology", HttpStatus.OK);

	}

}
