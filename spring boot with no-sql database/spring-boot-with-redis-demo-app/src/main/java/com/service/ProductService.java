package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Cacheable(value = "product",key = "#pid")
	public Product findProductById(int pid) {
		
		return productRepository.findProductById(pid).orElse(null);
	}
}