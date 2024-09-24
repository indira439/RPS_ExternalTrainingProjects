package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		 return productRepo.findAll();
	}
	
	public String storeProduct(Product product) {
		Optional<Product> result = productRepo.findById(product.getPid());
		if(result.isPresent()) {
			return "Product id must be unique";
		}else {
			productRepo.save(product);
			return "Product details stored in db";
		}
	}
	public String updateProduct(Product product) {
		Optional<Product> result = productRepo.findById(product.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setPrice(product.getPrice());
			productRepo.saveAndFlush(p);
			return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepo.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			productRepo.delete(p);;
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	

}
