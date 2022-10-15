package com.ratna.boot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ratna.boot.kafka.config.KafkaTopicConfiguration;

@Service
public class KafkaProducerString {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerString.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private KafkaTopicConfiguration kafkaTopicConfiguration;

	public void sendMessage(String message) {
		LOGGER.info("Message Produced " + message);
		kafkaTemplate.send(kafkaTopicConfiguration.applicationEventTopic().name(), message);
	}

}
