package com.ratna.boot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.ratna.boot.kafka.config.KafkaTopicConfiguration;
import com.ratna.boot.kafka.model.ApplicationEvent;

@Service
public class KafkaProducerJson {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerJson.class);

	@Autowired
	private KafkaTemplate<String, ApplicationEvent> kafkaTemplate;
	@Autowired
	private KafkaTopicConfiguration kafkaTopicConfiguration;

	public void sendEvent(ApplicationEvent event) {
		LOGGER.info("Produce Event Data", event);
		Message<ApplicationEvent> message = MessageBuilder.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, kafkaTopicConfiguration.applicationEventTopicJson().name()).build();
		kafkaTemplate.send(message);
	}

}
