package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "brand")
public class BrandModel {
	
	public static final String SEQUENCE_NAME = "brand_sequence";
	public static final String COLLECTION_NAME = "brand";
	
	@Id
	private Long id;
	private String name;
	
	public BrandModel(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BrandModel() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
