package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemp;
	
	@GetMapping(value = "sendMsg/{msg}")
	public String sendMessage(@PathVariable("msg") String msg)
	{
		kafkaTemp.send("spring_topic",msg);
		return "data sent";
	}

}
