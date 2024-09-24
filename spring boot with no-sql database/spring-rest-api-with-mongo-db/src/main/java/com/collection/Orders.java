package com.collection;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "orders")
public class Orders {
@Id
private int oid;
private LocalDateTime ltd = LocalDateTime.now();
@DBRef			// each order can contains more than one product information 
private List<Product> orders;
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public LocalDateTime getLtd() {
	return ltd;
}
public void setLtd(LocalDateTime ltd) {
	this.ltd = ltd;
}
public List<Product> getOrders() {
	return orders;
}
public void setOrders(List<Product> orders) {
	this.orders = orders;
}

}