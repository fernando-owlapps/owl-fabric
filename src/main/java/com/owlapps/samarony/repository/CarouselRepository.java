package com.owlapps.samarony.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.CarouselModel;
import com.owlapps.samarony.model.Image;

public interface CarouselRepository extends MongoRepository<CarouselModel, String> {

	CarouselModel findById(Long id);
	
	List<CarouselModel> findByEnabled(boolean enabled);

}
