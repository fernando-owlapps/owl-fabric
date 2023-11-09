package com.owlapps.samarony.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.owlapps.samarony.request.AddUserRequest;

@Document(collection = "user")
public class User {
	
	public static final String SEQUENCE_NAME = "user_sequence";
	public static final String COLLECTION_NAME = "user";

	@Id
	private Long id;
	
	@Field("document")
	private String document;
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String cellPhone;
	private String password;
	private int appVersion;
	private String deviceDna;
	private String tokenPush;
	private String createAt;
	private String updateAt;
	private String lastAccess;
	private Boolean readTermsAndCondition;
	private Boolean block;
	
	
	public User() {
		
	}
	
	public User(Long id) {
		this.id = id;
	}
	
	public User(Long id, String document, String firstName, String lastName, String fullName, String cellPhone,
			String password, int appVersion, String deviceDna, String tokenPush, String createAt, String updateAt,
			String lastAccess, Boolean readTermsAndCondition, Boolean block) {
		super();
		this.id = id;
		this.document = document;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.cellPhone = cellPhone;
		this.password = password;
		this.appVersion = appVersion;
		this.deviceDna = deviceDna;
		this.tokenPush = tokenPush;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.lastAccess = lastAccess;
		this.readTermsAndCondition = readTermsAndCondition;
		this.block = block;
	}

	public User(AddUserRequest addUserRequest) {
		super();
		this.id = addUserRequest.getId();
		this.document = addUserRequest.getDocument();
		this.firstName = addUserRequest.getFirstName();
		this.lastName = addUserRequest.getLastName();
		this.fullName = addUserRequest.getFullName();
		this.cellPhone = addUserRequest.getCellPhone();
		this.password = addUserRequest.getPassword();
		this.appVersion = addUserRequest.getAppVersion();
		this.deviceDna = addUserRequest.getDeviceDNA();
		this.tokenPush = addUserRequest.getTokenPush();
		
		this.createAt = addUserRequest.getCreateAt();
		this.updateAt = addUserRequest.getUpdateAt();
		this.lastAccess = addUserRequest.getLastAccess();
		this.readTermsAndCondition = addUserRequest.getReadTermsAndCondition();
		this.block = addUserRequest.getBlock();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public String getDeviceDna() {
		return deviceDna;
	}

	public void setDeviceDna(String deviceDna) {
		this.deviceDna = deviceDna;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", document=" + document + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fullName=" + fullName + ", cellPhone=" + cellPhone + ", password=" + password + ", appVersion="
				+ appVersion + ", deviceDna=" + deviceDna + ", tokenPush=" + tokenPush + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + ", lastAccess=" + lastAccess + ", readTermsAndCondition="
				+ readTermsAndCondition + ", block=" + block + "]";
	}
	
}
