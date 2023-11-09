package com.owlapps.samarony.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class ProductModel {
	
	public static final String SEQUENCE_NAME = "product_sequence";
	public static final String COLLECTION_NAME = "product";
	
	@Id
	private Long id;
	
	private String name;
	private String description;
	private String price;
	private int quantity;
	private String brandSelected;
	private String departamentSelected;
	private String sizeSelected;
	private List<BrandModel> brandList;
	private List<DepartamentModel> departamentList;
	private List<SizeModel> sizeList;
	private List<Image> imageList;
	private String imageFront;
	
	
	public ProductModel() {
	}
	
	public ProductModel(Long id, String name, String description, String price, int quantity, String brandSelected, String departamentSelected,
			String sizeSelected) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.brandSelected = brandSelected;
		this.departamentSelected = departamentSelected;
		this.sizeSelected = sizeSelected;
	}
	
	public ProductModel(Long id, String name, String description, String price, int quantity, String brandSelected, String departamentSelected,
			String sizeSelected, String imageFront) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.brandSelected = brandSelected;
		this.departamentSelected = departamentSelected;
		this.sizeSelected = sizeSelected;
		this.imageFront = imageFront;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<BrandModel> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<BrandModel> brandList) {
		this.brandList = brandList;
	}
	public List<DepartamentModel> getDepartamentList() {
		return departamentList;
	}
	public void setDepartamentList(List<DepartamentModel> departamentList) {
		this.departamentList = departamentList;
	}
	public List<SizeModel> getSizeList() {
		return sizeList;
	}
	public void setSizeList(List<SizeModel> sizeList) {
		this.sizeList = sizeList;
	}
	public String getBrandSelected() {
		return brandSelected;
	}
	public void setBrandSelected(String brandSelected) {
		this.brandSelected = brandSelected;
	}
	public String getDepartamentSelected() {
		return departamentSelected;
	}
	public void setDepartamentSelected(String departamentSelected) {
		this.departamentSelected = departamentSelected;
	}
	public String getSizeSelected() {
		return sizeSelected;
	}
	public void setSizeSelected(String sizeSelected) {
		this.sizeSelected = sizeSelected;
	}
	public List<Image> getImageList() {
		return imageList;
	}
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	public String getImageFront() {
		return imageFront;
	}
	public void setImageFront(String imageFront) {
		this.imageFront = imageFront;
	}
}
