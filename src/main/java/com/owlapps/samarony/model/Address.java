package com.owlapps.samarony.model;

public class Address {

	private String zipcode;
	private String address;
	private String neighborhood;
	private String city;
	private String state;
	
	public Address(Endereco endereco) {
		super();
		this.zipcode = endereco.getCep();
		this.address = endereco.getLogradouro();
		this.neighborhood = endereco.getBairro();
		this.city = endereco.getLocalidade();
		this.state = endereco.getUf();
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
