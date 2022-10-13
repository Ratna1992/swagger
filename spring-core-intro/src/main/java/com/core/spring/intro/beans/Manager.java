package com.core.spring.intro.beans;

import org.springframework.stereotype.Component;

@Component
public class Manager implements People {

	@Override
	public String designation() {
		
		return "Manager";
	}

}
