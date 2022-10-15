package com.ratna.boot.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ratna.boot.kafka.model.ApplicationEvent;

@Service
public class KafkaConsumerJson {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerJson.class);

	@KafkaListener(topics = "application-events-json", groupId = "applicationGroup")
	public void consume(ApplicationEvent event) {
		LOGGER.info("message recieved " + event);
	}
}
