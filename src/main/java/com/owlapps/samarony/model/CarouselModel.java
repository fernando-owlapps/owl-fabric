package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "carousel")
public class CarouselModel {
	
	public static final String SEQUENCE_NAME = "carousel_sequence";
	public static final String COLLECTION_NAME = "carousel";

	@Id
	private Long id;
	
	private String url;
	private String name;
	
	@Field("enabled")
	private Boolean enabled;
	
	private String createAt;
	private String updateAt;
	
	
	public CarouselModel(Long id, String url, String name, Boolean enabled, String createAt, String updateAt) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.enabled = enabled;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public CarouselModel() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
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

	@Override
	public String toString() {
		return "CarouselModel [id=" + id + ", url=" + url + ", name=" + name + ", enabled=" + enabled + ", createAt="
				+ createAt + ", updateAt=" + updateAt + "]";
	}
	
}
