package com.ratna.boot.secure.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmployeeDataService {
	public Map<String, Object> getEmployeeDataList() {
		Map<String, Object> data = new HashMap<>();
		data.put("name", "ratna");
		data.put("age", "30");
		data.put("designation", "Lead");
		data.put("sal", "123456");
		data.put("mobile", "8499899121");
		data.put("address", "hyderabad");

		return data;
	}
}
