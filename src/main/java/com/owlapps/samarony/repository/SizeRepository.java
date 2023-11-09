package com.owlapps.samarony.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.SizeModel;

public interface SizeRepository extends MongoRepository<SizeModel, Long> {

	
}
