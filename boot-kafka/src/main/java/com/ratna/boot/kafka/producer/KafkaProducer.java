package com.ratna.boot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ratna.boot.kafka.config.KafkaTopicConfiguration;
import com.ratna.boot.kafka.model.ApplicationEvent;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, ApplicationEvent> kafkaTemplate;
	@Autowired
	private KafkaTopicConfiguration kafkaTopicConfiguration;

	public void sendMessage(ApplicationEvent event) {
		LOGGER.info("Event Data", event);
		kafkaTemplate.send(kafkaTopicConfiguration.applicationEventTopic().name(), event);
	}

}
