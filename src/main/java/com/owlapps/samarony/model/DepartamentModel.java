package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departament")
public class DepartamentModel {
	
	public static final String SEQUENCE_NAME = "departament_sequence";
	public static final String COLLECTION_NAME = "departament";
	
	@Id
	private Long id;
	private String name;
	
	public DepartamentModel(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public DepartamentModel() {
		
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
