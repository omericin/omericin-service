package com.web.phone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web.phone.model.Storage;

public interface StorageRepository extends MongoRepository<Storage, String>{

}
