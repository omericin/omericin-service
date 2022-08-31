package com.web.phone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web.phone.model.Color;

public interface ColorRepository extends MongoRepository<Color, String>{

}
