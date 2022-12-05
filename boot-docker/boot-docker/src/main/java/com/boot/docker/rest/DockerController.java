package com.boot.docker.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/docker")
public class DockerController {

	@GetMapping("/details")
	public Map<String, Object> getDetails() {

		Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
		hashMap.put("name", "Ratna Srinivasa Rao Karicherla");
		hashMap.put("subject", "Docker");
		hashMap.put("goal", "Mastering Docker");
		return hashMap;
	}

}
