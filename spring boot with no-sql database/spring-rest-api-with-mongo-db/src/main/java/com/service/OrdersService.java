package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.Orders;
import com.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	public String placeOrder(Orders order) {
		Optional<Orders> result = ordersRepository.findById(order.getOid());
		if(result.isPresent()) {
			return "OId is unique";
		}else {
			ordersRepository.save(order);
			return "Your order placed successfully";
		}
	}
	
	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}
}