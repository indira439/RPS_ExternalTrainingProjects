package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.collection.Orders;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, Integer>{

}