package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service								// Service layer annotation 
public class ProductService {
	//private ProductDao pd = new ProductDao();
	
	@Autowired
	ProductDao productDao;
	
	public String addProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Product price must be > 1000";
		}else if(productDao.storeProduct(product)>0) {
			return "Product details stored in database";
		}else {
			return "Product didn't store";
		}
	}
	public List<Product> findAllProducts(){
		List<Product> listOfProduct = productDao.retrieveAllProductAsList();
		Iterator<Product> li = listOfProduct.iterator();
		while(li.hasNext()) {
			Product p = li.next();
			float discount = p.getPrice()*0.10f;
			p.setPrice(p.getPrice()-discount);
		}
		return listOfProduct;
	}
	public String deleteProduct(int pid) {
		if(productDao.deleteProduct(pid)>0) {
			return "Product removed successfully";
		}else {
			return "Product not present";
		}
	}
	public String updatetProduct(Product product) {
		if(productDao.updateProduct(product)>0) {
			return "Product price updated successfully";
		}else {
			return "product not present";
		}
	}
	
	public List<Map<String,Object>> retrieveAllProductsAsListOfMap() {
		return productDao.retrieveAllProductsAsListOfMap();
	}
	
	
}