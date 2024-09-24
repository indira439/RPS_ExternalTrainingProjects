package com.userobject;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeSerializer implements Serializer<Employee>{

	@Override
	public byte[] serialize(String topic, Employee data) {
		// TODO Auto-generated method stub
		byte[] empData = null;
		try {
			System.out.println(data);
			ObjectMapper objMp = new ObjectMapper(); // help to convert our object in byte format.
			empData = objMp.writeValueAsString(data).getBytes();
			System.out.println(empData);
		}
		catch(Exception exp){
			
		}
		return empData;
	}


}
