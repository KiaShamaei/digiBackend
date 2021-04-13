package com.healthy.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="Users")
@NamedQueries({
	@NamedQuery(name= "Users.findUsers" , query = "SELECT e FROM Users e WHERE e.MobileNumber = :mobileNumber "),
	@NamedQuery(name= "Users.loginUsers" , query = "SELECT e FROM Users e WHERE e.MobileNumber = :mobileNumber and e.Password = :password ")
})

public class Users {
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "UserId")
	private  Long userId;
	@Column(name = "Name", columnDefinition = "nvarchar (1000)")
	private String Name ;
	@Column(  columnDefinition = "nvarchar (1000)")
	private String Family;
	private String MobileNumber ; 
	private String Email ;
	private String Password;
	private Date CreateDate ; 
	private Boolean IsActive;
	@Column( nullable = true)
	private int UserTypeId;
	
	public Users(Long userId, String name, String family, String mobileNumber, String email, String password,
			Date createDate, Boolean isActive, int userTypeId) {
		super();
		this.userId = userId;
		Name = name;
		Family = family;
		MobileNumber = mobileNumber;
		Email = email;
		Password = password;
		CreateDate = createDate;
		IsActive = isActive;
		UserTypeId = userTypeId;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFamily() {
		return Family;
	}
	public void setFamily(String family) {
		Family = family;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
	public int getUserTypeId() {
		return UserTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		UserTypeId = userTypeId;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", Name=" + Name + ", Family=" + Family + ", MobileNumber=" + MobileNumber
				+ ", Email=" + Email + ", Password=" + Password + ", CreateDate=" + CreateDate + ", IsActive="
				+ IsActive + ", UserTypeId=" + UserTypeId + "]";
	}
	
	
	
	
	
	
}
