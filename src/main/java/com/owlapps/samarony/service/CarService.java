package com.owlapps.samarony.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.owlapps.samarony.model.CarModel;
import com.owlapps.samarony.model.ProductModel;
import com.owlapps.samarony.repository.CarRepository;

@Service
public class CarService {

	@Autowired
    CarRepository carRepository;
	
	
	public List<CarModel> getAllCarsSortBy(Integer pageNo, Integer pageSize, String sortBy){
		
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<CarModel> pagedResult = carRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CarModel>();
        }
    }
	
	public List<CarModel> getAllCars(Integer pageNo, Integer pageSize){
		
        Pageable paging = PageRequest.of(pageNo, pageSize);
 
        Page<CarModel> pagedResult = carRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CarModel>();
        }
    }
}
