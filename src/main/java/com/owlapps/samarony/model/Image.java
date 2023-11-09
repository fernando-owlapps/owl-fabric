package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "image")
public class Image {

	public static final String SEQUENCE_NAME = "image_sequence";
	public static final String COLLECTION_NAME = "image";
	
	@Id
	private Long id;
	
	private String name;
	
	@Field("plate")
	private String plate;
	
	@Field("enabled")
	private boolean enabled;
	
	private String createAt;
	
	private String updateAt;
	
	
	public Image(Long id, String name, String plate, boolean enabled, String createAt, String updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.plate = plate;
		this.enabled = enabled;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
}
