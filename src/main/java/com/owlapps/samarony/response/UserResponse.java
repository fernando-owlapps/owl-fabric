package com.owlapps.samarony.response;

import com.owlapps.samarony.model.User;

public class UserResponse {

	private User user;
	private String message;
	
	
	public UserResponse(User user, String message) {
		super();
		this.user = user;
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
