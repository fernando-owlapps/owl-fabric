package com.owlapps.samarony.request;

public class AddUserRequest {
	
	private Long id;
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String document;
	private String cellPhone;
	private String password;
	private int appVersion;
	private String deviceDNA;
	private String tokenPush;
	private String createAt;
	private String updateAt;
	private String lastAccess;
	private Boolean readTermsAndCondition;
	private Boolean block;
	
	public AddUserRequest(Long id, String firstName, String lastName, String fullName, String document,
			String cellPhone, String password, int appVersion, String deviceDNA, String tokenPush, String createAt,
			String updateAt, String lastAccess, Boolean readTermsAndCondition, Boolean block) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.document = document;
		this.cellPhone = cellPhone;
		this.password = password;
		this.appVersion = appVersion;
		this.deviceDNA = deviceDNA;
		this.tokenPush = tokenPush;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.lastAccess = lastAccess;
		this.readTermsAndCondition = readTermsAndCondition;
		this.block = block;
	}
	
	public AddUserRequest() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(int appVersion) {
		this.appVersion = appVersion;
	}

	public String getDeviceDNA() {
		return deviceDNA;
	}

	public void setDeviceDNA(String deviceDNA) {
		this.deviceDNA = deviceDNA;
	}

	public String getTokenPush() {
		return tokenPush;
	}

	public void setTokenPush(String tokenPush) {
		this.tokenPush = tokenPush;
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

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Boolean getReadTermsAndCondition() {
		return readTermsAndCondition;
	}

	public void setReadTermsAndCondition(Boolean readTermsAndCondition) {
		this.readTermsAndCondition = readTermsAndCondition;
	}

	public Boolean getBlock() {
		return block;
	}

	public void setBlock(Boolean block) {
		this.block = block;
	}
	
}
