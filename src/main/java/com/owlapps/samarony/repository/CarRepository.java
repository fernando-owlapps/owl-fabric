package com.owlapps.samarony.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.CarModel;

public interface CarRepository extends MongoRepository<CarModel, Long> {

	CarModel findByPlate(final String plate);
	
	List<CarModel> findByIdUser(final long idUser);
	
//	CarModel findById(final Long id);
}
