package com.web.phone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.web.phone.model.Price;

public interface PriceRepository extends MongoRepository<Price, String>{
	
    @Query(value="{brandId:'?0', size:'?1', status:'?2'}", fields="{'price' : 1}")
    Price findPriceById(String brandId, String size, String status);

}
