package com.owlapps.samarony.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.Image;

public interface ImageRepository extends MongoRepository<Image, String> {

	List<Image> findByPlate(final String plate);
	
	List<Image> findByPlateAndEnabled(final String plate, boolean enabled);
	
	Image findById(final Long id);
}
