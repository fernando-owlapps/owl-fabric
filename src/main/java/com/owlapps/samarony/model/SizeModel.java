package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "size")
public class SizeModel {
	
	public static final String SEQUENCE_NAME = "size_sequence";
	public static final String COLLECTION_NAME = "size";
	
	@Id
	private Long id;
	private String name;
	
	public SizeModel(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public SizeModel() {
		
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
