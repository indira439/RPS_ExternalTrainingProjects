package com.emp;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class EmployeeConsumer {
	public static void main(String[] args) {
		String topicName ="emp_topic";
		
		Properties pp = new Properties();
		
		pp.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");		// link to Apache broker server 
		pp.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());		// key type of string 
		pp.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EmployeeDesializer.class.getName());		// value type string
		pp.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "g1");
		
		
		Consumer<String,Employee> consumer= new KafkaConsumer<String, Employee>(pp);
		consumer.subscribe(Arrays.asList(topicName));		// link to topic , link to channel or topic 
		System.out.println("Consumer waiting to put the message ");
		while(true) {
		
			ConsumerRecords<String, Employee> consumerRecords= consumer.poll(Duration.ofMinutes(10));
		for(ConsumerRecord<String, Employee> record:consumerRecords) {
			System.out.println("key "+record.key()+" Name is "+record.value().getFname()+" Age is "+record.value().getAge());
		}
		
		}
		
		//consumer.close();
	}
}