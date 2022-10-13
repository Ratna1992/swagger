package com.core.spring.intro.beans;

import org.springframework.stereotype.Component;

@Component
public class Employee implements People {

	@Override
	public String designation() {
		return "employee";
	}

}
