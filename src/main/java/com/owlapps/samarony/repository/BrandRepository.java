package com.owlapps.samarony.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.BrandModel;

public interface BrandRepository extends MongoRepository<BrandModel, Long> {

	
}
