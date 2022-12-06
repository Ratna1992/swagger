package com.boot.jenkins.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/jenkins")
public class JenkinsController {

	@GetMapping("/details")
	public Map<String, Object> getDetails() {

		Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
		hashMap.put("name", "Ratna Srinivasa Rao Karicherla");
		hashMap.put("subject", "Jenkins");
		hashMap.put("goal", "Mastering Jenkins");
		return hashMap;
	}
}
