package com.owlapps.samarony.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.DepartamentModel;

public interface DepartamentRepository extends MongoRepository<DepartamentModel, Long> {

	
}
