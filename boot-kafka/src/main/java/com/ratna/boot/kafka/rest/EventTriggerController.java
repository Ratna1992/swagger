package com.ratna.boot.kafka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.boot.kafka.model.ApplicationEvent;
import com.ratna.boot.kafka.producer.KafkaProducerJson;
import com.ratna.boot.kafka.producer.KafkaProducerString;

@RestController
@RequestMapping("/trigger")
public class EventTriggerController {

	@Autowired
	private KafkaProducerString producerString;

	@Autowired
	private KafkaProducerJson producerJson;

	@GetMapping("/message")
	private ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		producerString.sendMessage(message);
		return new ResponseEntity<String>("Event Triggered", HttpStatus.OK);

	}

	@PostMapping("/event")
	private ResponseEntity<String> sendEvent(@RequestBody ApplicationEvent event) {
		producerJson.sendEvent(event);
		return new ResponseEntity<String>("Event Triggered", HttpStatus.OK);

	}
}
