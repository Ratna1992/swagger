package com.ratna.boot.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

	@Bean
	public NewTopic applicationEventTopic() {
		return TopicBuilder.name("application-events").build();
	}

	@Bean
	public NewTopic applicationEventTopicJson() {
		return TopicBuilder.name("application-events-json").build();
	}

}
