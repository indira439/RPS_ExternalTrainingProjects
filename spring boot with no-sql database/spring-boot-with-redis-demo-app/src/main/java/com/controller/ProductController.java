package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductService;

@RestController
@RequestMapping("rcache")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(value = "findbyid/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Product findProduct(@PathVariable("pid") int pid) {
		return productService.findProductById(pid);
	}
}