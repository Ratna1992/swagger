package com.boot.elk.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.boot.elk.model.ELKModel;

@Service
public class ELKService {

	Logger LOG = LoggerFactory.getLogger(ELKService.class);

	public ELKModel getRecord(String id) {
		ELKModel elkModel = getStashRecords().stream().filter(obj -> obj.getId().equalsIgnoreCase(id)).findFirst()
				.orElse(null);
		if (elkModel != null) {
			LOG.info("record found : {}", elkModel);
			return elkModel;
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("no record found with ID :{} ", id);
				return new ELKModel();
			}

		}
	}

	private List<ELKModel> getStashRecords() {
		ELKModel elkModel1 = new ELKModel("1", "2022:10:28:00:00:00", "Null pointer", "boot-elk");
		ELKModel elkModel2 = new ELKModel("2", "2022:10:28:00:10:00", "ArrayIndex", "boot-elk");
		ELKModel elkModel3 = new ELKModel("3", "2022:10:28:20:00:00", "Concurrent Modification", "boot-elk");
		ELKModel elkModel4 = new ELKModel("4", "2022:10:28:30:00:00", "class cast", "boot-elk");

		return Arrays.asList(elkModel1, elkModel2, elkModel3, elkModel4);
	}
}
