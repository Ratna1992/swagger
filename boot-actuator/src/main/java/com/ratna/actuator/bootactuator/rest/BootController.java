package com.ratna.actuator.bootactuator.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {

	@GetMapping("/isActuatorEnabled")
	public String isActuatorEnabled() {
		return "Yes, actuator enabled";
	}

}
