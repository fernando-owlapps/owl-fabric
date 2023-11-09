package com.owlapps.samarony.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "car")
public class CarModel {
	
	public static final String SEQUENCE_NAME = "car_sequence";
	public static final String COLLECTION_NAME = "car";
	
	@Id
	private Long id;
	
	private String cellphone;
	private String price;
	
	@Field("plate")
	private String plate;
	
	@Field("idUser")
	private Long idUser;
	
	private String color;
	private String modelo;

	private String marca;
	private String uf;
	private String city;
	private String motor;
	private String valvula;
	private String ports;
	private String cambio;
	private String year;
	private String km;
	private String fuel;
	private String type;
	private String armored;
	private String description;
	
	private String shortDescription;
	
	private List<Image> imageUrlList;
	private String imageFront;
	
	private String createAt;
	
	private String updateAt;
	
	private Boolean sold;
	private Boolean pause;
	private Boolean disabled;
	
	
	public CarModel() {
	}


	public CarModel(Long id, String cellphone, String price, String plate, Long idUser, String color, String modelo, String marca,
			String uf, String city, String motor, String valvula, String ports, String cambio, String year, String km,
			String fuel, String type, String armored, String description, String shortDescription, List<Image> imageUrlList,
			String imageFront, String createAt, String updateAt, Boolean sold, Boolean pause, Boolean disabled) {
		super();
		this.id = id;
		this.cellphone = cellphone;
		this.price = price;
		this.plate = plate;
		this.idUser = idUser;
		this.color = color;
		this.modelo = modelo;
		this.marca = marca;
		this.uf = uf;
		this.city = city;
		this.motor = motor;
		this.valvula = valvula;
		this.ports = ports;
		this.cambio = cambio;
		this.year = year;
		this.km = km;
		this.fuel = fuel;
		this.type = type;
		this.armored = armored;
		this.description = description;
		this.shortDescription = shortDescription;
		this.imageUrlList = imageUrlList;
		this.imageFront = imageFront;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.sold = sold;
		this.pause = pause;
		this.disabled = disabled;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	
	public long getIdUser() {
		return idUser;
	}


	public void setUser(long idUser) {
		this.idUser = idUser;
	}	
	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMotor() {
		return motor;
	}


	public void setMotor(String motor) {
		this.motor = motor;
	}


	public String getValvula() {
		return valvula;
	}


	public void setValvula(String valvula) {
		this.valvula = valvula;
	}


	public String getPorts() {
		return ports;
	}


	public void setPorts(String ports) {
		this.ports = ports;
	}


	public String getCambio() {
		return cambio;
	}


	public void setCambio(String cambio) {
		this.cambio = cambio;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getKm() {
		return km;
	}


	public void setKm(String km) {
		this.km = km;
	}


	public String getFuel() {
		return fuel;
	}


	public void setFuel(String fuel) {
		this.fuel = fuel;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getArmored() {
		return armored;
	}


	public void setArmored(String armored) {
		this.armored = armored;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getShortDescription() {
		return getMotor() + " " + getValvula() + " " + getFuel() + " " + getPorts() + " " + getCambio();
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public List<Image> getImageUrlList() {
		return imageUrlList;
	}


	public void setImageUrlList(List<Image> urlList) {
		this.imageUrlList = urlList;
	}


	public String getImageFront() {
		return imageFront;
	}


	public void setImageFront(String imageFront) {
		this.imageFront = imageFront;
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


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	public Boolean getPause() {
		return pause;
	}

	public void setPause(Boolean pause) {
		this.pause = pause;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}


	@Override
	public String toString() {
		return "CarModel [id=" + id + ", cellphone=" + cellphone + ", price=" + price + ", plate=" + plate + ", idUser="
				+ idUser + ", color=" + color + ", modelo=" + modelo + ", marca=" + marca + ", uf=" + uf + ", city="
				+ city + ", motor=" + motor + ", valvula=" + valvula + ", ports=" + ports + ", cambio=" + cambio
				+ ", year=" + year + ", km=" + km + ", fuel=" + fuel + ", type=" + type + ", armored=" + armored
				+ ", description=" + description + ", shortDescription=" + shortDescription + ", imageUrlList="
				+ imageUrlList + ", imageFront=" + imageFront + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ ", sold=" + sold + ", pause=" + pause + ", disabled=" + disabled + "]";
	}
	
}
