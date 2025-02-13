package com.userobject;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;



public class EmployeeProducer {
	
	public static void main(String[] args) {
		
		String topicName = "emp_topic";
		
		Properties prop = new Properties();
		
		prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");  // link to Apache broker server 
		prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());  // key type of string 
		prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EmployeeSerializer.class.getName());  // value type is Employee 
		
		Employee emp = new Employee(1, "Indu");
		
		Producer<String, Employee> producerRef = new KafkaProducer<String, Employee>(prop);
		
		ProducerRecord<String, Employee> data = new ProducerRecord<String, Employee>(topicName, emp);
		
		producerRef.send(data);
		producerRef.close();
		System.out.println("Send emp data successfully using java to apache kafka");
	}
	

}
