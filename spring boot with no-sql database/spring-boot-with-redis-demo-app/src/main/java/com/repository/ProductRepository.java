package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public class ProductRepository {
	static List<Product> listOfProdut = new ArrayList<Product>();
	static {
		Product p1 = new Product(100,"TV",45000);
		Product p2 = new Product(101,"Computer",67000);
		Product p3 = new Product(102,"Pen Drive",1500);
		listOfProdut.add(p1);
		listOfProdut.add(p2);
		listOfProdut.add(p3);
	}
	// this information we can retrieve from mysql db 
	
	public Optional<Product> findProductById(int pid) {
		System.out.println("it hit repository layer with pid as "+pid);
		return listOfProdut.stream().filter(p->p.getPid()==pid).findFirst();
	}
	
}