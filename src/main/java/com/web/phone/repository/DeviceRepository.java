package com.web.phone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web.phone.model.Device;

public interface DeviceRepository extends MongoRepository<Device, String>{
	
}
