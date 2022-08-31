package com.web.phone.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.web.phone.model.Brand;

public interface BrandRepository extends MongoRepository<Brand, String>{
	
    @Query(value="{deviceId:'?0'}", fields="{'price' : 1, 'deviceId': 1, 'name': 1, 'image': 1, 'colorList': 1, 'storageList': 1}")
    List<Brand> findBrandByDeviceId(String deviceId);


}
