package com.example.demo.rest;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/screen/")
@Api("Boot  Controller Screens")
public class BootController {

	@GetMapping("/display/{name}")
	@ApiOperation("Display name you enter in map object.")
	public Person displayName(@PathParam("name") String name) {

		Person person = new Person();
		person.setFirstName(name);
		return person;
	}
}
