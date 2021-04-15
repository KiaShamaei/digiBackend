package com.healthy.project.model;

public class UserInfo {
	
	private String userInfo;
	private Boolean isValid ;
	public String getUserInfo() {
		return userInfo;
	}



	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}



	public Boolean getIsValid() {
		return isValid;
	}



	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	private String token;

	

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

}
