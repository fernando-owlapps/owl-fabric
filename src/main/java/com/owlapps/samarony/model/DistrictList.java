package com.owlapps.samarony.model;

import java.util.List;

public class DistrictList {

	private List<District> distrito;

	public DistrictList(List<District> distrito) {
		super();
		this.distrito = distrito;
	}
	
	public DistrictList() {
		super();
	}

	public List<District> getDistrito() {
		return distrito;
	}

	public void setDistrito(List<District> distrito) {
		this.distrito = distrito;
	}
	
}
