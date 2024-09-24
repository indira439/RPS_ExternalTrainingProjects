package com.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@KafkaListener(topics = "spring_topic",groupId = "g1")
	public void reciveMessageFromKakfa(@Payload String message) {
		System.out.println(message);
	}
}
