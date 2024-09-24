package com;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String topicName = "topic1";
		Properties pp = new Properties();
		
		pp.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");		// link to Apache broker server 
		pp.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());		// key type of string 
		pp.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());		// value type string
		
		Producer<String, String> producerRef = new KafkaProducer<String, String>(pp);	// kakfa producer ref ready to send the data 

		ProducerRecord<String, String> data = new ProducerRecord<String, String>(topicName, "This message send through Java program to topic1");
		
		producerRef.send(data);
		
		producerRef.close();
		System.out.println("Send Messasge successfully using java to apache kafka");

	}

}
